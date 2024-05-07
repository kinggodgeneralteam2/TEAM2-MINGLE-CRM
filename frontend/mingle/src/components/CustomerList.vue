<template>
  <div class="customer-list-container">
    <div class="customer-list">
      <h2>고객 목록</h2>
      <table v-if="customers.length > 0" class="customer-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>고객명</th>
            <th>고객 등급</th>
            <th>전화번호</th>
            <th>주소</th>
            <th>사용자</th>
            <th>메모</th>
            <th>성별</th>
            <th>생년월일</th>
          </tr>
        </thead>
        <tbody>
          <tr
            v-for="customer in customers"
            :key="customer.id"
            class="customer-row"
            @click="goToCustomerDetail(customer.id)"
          >
            <td>{{ customer.id }}</td>
            <td>{{ customer.name }}</td>
            <td>{{ customer.customerGroup }}</td>
            <td>{{ customer.phone }}</td>
            <td>{{ customer.address }}</td>
            <td>{{ customer.user }}</td>
            <td>{{ customer.memo }}</td>
            <td>{{ customer.gender }}</td>
            <td>{{ customer.birth }}</td>
          </tr>
        </tbody>
      </table>
      <p v-else class="empty-message">고객이 없습니다.</p>
      <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      customers: [],
      errorMessage: "",
    };
  },
  created() {
    this.fetchCustomers();
  },
  methods: {
    async fetchCustomers() {
      try {
        const response = await axios.get("http://localhost:3000/customers");
        this.customers = response.data;
        this.errorMessage = "";
      } catch (error) {
        console.error("고객 목록을 불러오는 중 에러 발생:", error);
        this.errorMessage = "고객 목록을 불러오는 중 에러가 발생했습니다.";
      }
    },
    goToCustomerDetail(customerId) {
      this.$router.push({ name: "CustomerDetail", params: { id: customerId } });
    },
  },
};
</script>

<style scoped>
.customer-list-container {
  max-width: 1000px;
  margin: 0 auto;
}

.customer-list {
  background-color: #f5f5f5;
  border-radius: 10px;
  padding: 20px;
}

.customer-table {
  width: 100%;
  border-collapse: collapse;
}

.customer-table th,
.customer-table td {
  border: 1px solid #dddddd;
  padding: 8px;
  text-align: left; /* 레코드는 왼쪽 정렬 */
}

.customer-table th {
  background-color: #f2f2f2;
  font-weight: bold;
  text-align: center; /* 헤더는 가운데 정렬 */
}

.customer-table tr:nth-child(even) {
  background-color: #f9f9f9;
}

.customer-table tr:hover {
  background-color: #f2f2f2;
}

.empty-message,
.error-message {
  margin-top: 20px;
  text-align: center;
  color: #555555;
}

.error-message {
  color: red;
}
</style>
