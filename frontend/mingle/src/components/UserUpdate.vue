<template>
  <div class="login-page">
    <h1 v-if="user && user.name">{{ user.name }}님의 정보 수정 페이지</h1>
    <form v-if="user" @submit.prevent="updateUser" class="update-form">
      <div class="form-group">
        <label for="email">이메일</label>
        <input id="email" v-model="user.email" type="email" required>
      </div>
      <div class="form-group">
        <label for="name">이름</label>
        <input id="name" v-model="user.name" type="text" required>
      </div>
      <div class="form-group">
        <label for="phone">전화번호</label>
        <input id="phone" v-model="user.phone" type="tel" required>
      </div>
      <div class="form-group">
        <!-- 비밀번호 입력 필드 추가 -->
        <label for="password">비밀번호</label>
        <input id="password" v-model="user.password" type="password" required>
      </div>
      <button type="submit">저장</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      user: null
    };
  },
  created() {
    this.fetchUser();
  },
  methods: {
    async fetchUser() {
      try {
        const userId = this.$route.params.id;
        const response = await axios.get(`http://localhost:3000/users/${userId}`);
        this.user = response.data;
      } catch (error) {
        console.error('Error fetching user data:', error);
      }
    },
    async updateUser() {
      try {
        const userId = this.$route.params.id;
        // PUT 요청 시 사용자 정보와 함께 URL에 사용자 ID를 포함시킵니다.
        await axios.put(`http://localhost:3000/users/${userId}`, this.user);
        alert('사용자 정보가 성공적으로 업데이트되었습니다.');
        console.log('사용자 정보가 성공적으로 업데이트되었습니다.');
        // 사용자 정보가 성공적으로 업데이트되면 다른 작업을 수행할 수 있습니다.
      } catch (error) {
        console.error('사용자 정보를 업데이트하는 중 에러가 발생했습니다:', error);
      }
    }
  }
};
</script>

<style scoped>
.login-page {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.update-form {
  max-width: 400px;
  margin: 0 auto;
}

.form-group {
  margin-bottom: 20px;
}

label {
  display: block;
  font-weight: bold;
}

input[type="email"],
input[type="text"],
input[type="tel"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

button[type="submit"] {
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

button[type="submit"]:hover {
  background-color: #0056b3;
}
</style>
