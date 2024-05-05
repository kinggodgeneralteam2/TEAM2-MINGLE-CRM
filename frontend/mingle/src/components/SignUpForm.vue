<template>
  <div>
    <h2>회원가입</h2>
    <form @submit.prevent="signUp" class="signup-form">
      <div class="form-group">
        <label for="email">이메일:</label>
        <input id="email" v-model="email" type="email" required>
      </div>
      <div class="form-group">
        <label for="name">이름:</label>
        <input id="name" v-model="name" type="text" required>
      </div>
      <div class="form-group">
        <label for="phone">전화번호:</label>
        <input id="phone" v-model="phone" type="tel" required>
      </div>
      <div class="form-group">
        <label for="password">비밀번호:</label>
        <input id="password" v-model="password" type="password" required>
      </div>
      <button type="submit" class="btn-submit">회원가입</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      email: '',
      name: '',
      phone: '',
      password: '',
      message: ''
    };
  },
  methods: {
    async signUp() {
      try {
        const response = await axios.post('/api/v1/auth/signup', {
          email: this.email,
          name: this.name,
          phone: this.phone,
          password: this.password
        });
        this.message = response.data.message;
      } catch (error) {
        if (error.response) {
          this.message = error.response.data.message;
        } else {
          this.message = '네트워크 오류: 서버에 연결할 수 없습니다.';
        }
      }
    }
  }
};
</script>

<style scoped>
.signup-form {
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

.btn-submit {
  background-color: #007bff;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

.btn-submit:hover {
  background-color: #0056b3;
}

.message {
  color: red;
  margin-top: 10px;
}
</style>

