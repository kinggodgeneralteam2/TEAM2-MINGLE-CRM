<template>
  <div class="customer-detail">
    <h2>고객 상세 정보</h2>
    <table class="customer-detail-table">
      <tbody>
        <tr>
          <td>id</td>
          <td>{{ customer.id }}</td>
        </tr>
        <tr>
          <td>이름</td>
          <td>{{ customer.name }}</td>
        </tr>
        <tr>
          <td>등급</td>
          <td>{{ customer.customerGroup }}</td>
        </tr>
        <tr>
          <td>전화번호</td>
          <td>{{ customer.phone }}</td>
        </tr>
        <tr>
          <td>주소</td>
          <td>{{ customer.address }}</td>
        </tr>
        <tr>
          <td>담당자</td>
          <td>{{ customer.user }}</td>
        </tr>
        <tr>
          <td>메모</td>
          <td>{{ customer.memo }}</td>
        </tr>
        <tr>
          <td>성별</td>
          <td>{{ customer.gender }}</td>
        </tr>
        <tr>
          <td>생일</td>
          <td>{{ customer.birth }}</td>
        </tr>
      </tbody>
    </table>
    <button @click="goToEditCustomerPage">고객 정보 수정</button>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      customer: {},
    };
  },
  created() {
    // 페이지가 생성될 때 해당 고객 정보를 가져오는 메서드 호출
    this.fetchCustomerDetails();
  },
  methods: {
    async fetchCustomerDetails() {
      try {
        // 해당 고객의 ID를 라우트 파라미터에서 가져옴
        const customerId = this.$route.params.id;
        // 해당 고객의 정보를 서버에서 가져옴
        const response = await axios.get(
          `http://localhost:3000/customers/${customerId}`
        );
        this.customer = response.data;
      } catch (error) {
        console.error("고객 정보를 불러오는 중 에러 발생:", error);
        // 에러 처리 로직 추가
      }
    },
    goToEditCustomerPage() {
      // 고객 정보 수정 페이지로 이동하는 메서드
      this.$router.push({
        name: "CustomerEdit",
        params: { id: this.customer.id },
      });
    },
  },
};
</script>

<style scoped>
.customer-detail {
  max-width: 800px;
  margin: 20px auto;
}

.customer-detail-table {
  width: 100%;
  border-collapse: collapse;
}

.customer-detail-table td {
  padding: 10px;
  border: 1px solid #dddddd;
}

.customer-detail-table td:first-child {
  font-weight: bold;
  width: 30%;
  background-color: #f2f2f2;
}

.customer-detail button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  max-width: 200px;
  align-self: center;
}

.customer-detail button:hover {
  background-color: #0056b3;
}
</style>
