<template>
  <div class="customer-edit">
    <h2>고객 정보 수정</h2>
    <form @submit.prevent="updateCustomer">
      <div v-for="(value, key) in customer" :key="key">
        <label :for="key">{{ getFieldName(key) }}</label>
        <input
          :id="key"
          v-model="editedCustomer[key]"
          :required="isRequired(key)"
          :disabled="isDisabled(key)"
          :class="{ disabled: isDisabled(key) }"
        />
      </div>
      <button type="submit">저장</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      customer: {},
      editedCustomer: {},
    };
  },
  created() {
    this.fetchCustomerDetails();
  },
  methods: {
    async fetchCustomerDetails() {
      try {
        const customerId = this.$route.params.id;
        const response = await axios.get(
          `http://localhost:3000/customers/${customerId}`
        );
        this.customer = response.data;
        this.editedCustomer = { ...this.customer };
      } catch (error) {
        console.error("고객 정보를 불러오는 중 에러 발생:", error);
      }
    },
    async updateCustomer() {
      try {
        const customerId = this.$route.params.id;
        await axios.put(
          `http://localhost:3000/customers/${customerId}`,
          this.editedCustomer
        );
        alert("고객 정보가 수정되었습니다.");
        this.$router.push({
          name: "CustomerDetail",
          params: { id: customerId },
        });
      } catch (error) {
        console.error("고객 정보를 수정하는 중 에러 발생:", error);
        alert("고객 정보를 수정하는 중 에러가 발생했습니다.");
      }
    },
    isRequired(key) {
      const requiredFields = ["name", "phone", "customerGroup"];
      return requiredFields.includes(key);
    },
    isDisabled(key) {
      const disabledFields = ["id"];
      return disabledFields.includes(key);
    },
    getFieldName(key) {
      // 각 속성에 대응되는 필드 이름을 반환하는 메서드
      const fieldNames = {
        id: "ID",
        name: "이름",
        customerGroup: "등급",
        phone: "전화번호",
        address: "주소",
        user: "담당자",
        memo: "메모",
        gender: "성별",
        birth: "생일",
      };
      return fieldNames[key] || key;
    },
  },
};
</script>

<style scoped>
.customer-edit {
  max-width: 800px;
  margin: 20px auto;
}

.customer-edit h2 {
  font-size: 24px;
  margin-bottom: 20px;
}

.customer-edit form {
  display: flex;
  flex-direction: column;
}

.customer-edit label {
  margin-bottom: 8px;
  padding-right: 10px;
}

.customer-edit input {
  padding: 8px;
  margin-bottom: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
}

.customer-edit input.disabled {
  background-color: #f5f5f5;
  color: #888;
}

.customer-edit button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  max-width: 100px;
  align-self: center;
}

.customer-edit button:hover {
  background-color: #0056b3;
}
</style>
