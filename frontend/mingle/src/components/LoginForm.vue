<template>
  <div class="signup-page">
    <h2>로그인</h2>
    <form @submit.prevent="login" class="login-form">
      <!-- 이메일 입력 -->
      <div class="form-group">
        <label for="email">이메일</label>
        <input id="email" v-model="email" type="email" required>
      </div>
      <!-- 비밀번호 입력 -->
      <div class="form-group">
        <label for="password">비밀번호</label>
        <input id="password" v-model="password" type="password" required>
      </div>
      <!-- 로그인 버튼 -->
      <button type="submit" class="btn-submit">로그인</button>
    </form>
    <!-- 로그인 결과 메시지 -->
    <p v-if="message" :class="{ message: true, 'message-success': isSuccess }">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      email: '',
      password: '',
      message: '',
      isSuccess: false // 로그인 성공 여부를 나타내는 변수 추가
    };
  },
  // methods: {
  //   async login() {
  //     try {
  //       // 서버에서 사용자 정보 가져오기
  //       const response = await axios.get('http://localhost:3000/users');
  //       const users = response.data;
  //
  //       // 사용자 배열이 정의되지 않은 경우 오류 처리
  //       if (!users || users.length === 0) {
  //         console.error('사용자 데이터가 없습니다.');
  //         this.message = '사용자 데이터가 없습니다.';
  //         return;
  //       }
  //
  //       // 로그인 시도
  //       const user = users.find(user => user.email === this.email && user.password === this.password);
  //       if (user) {
  //         // 로그인 성공 메시지 표시
  //         this.message = `${user.name}님, 환영합니다!`;
  //         this.isSuccess = true; // 성공 여부를 true로 설정하여 메시지 스타일 변경
  //       } else {
  //         // 로그인 실패 메시지 표시
  //         this.message = '이메일 또는 비밀번호가 잘못되었습니다.';
  //         this.isSuccess = false; // 성공 여부를 false로 설정하여 메시지 스타일 변경
  //       }
  //     } catch (error) {
  //       // 네트워크 오류 메시지 표시
  //       console.error('로그인 오류:', error);
  //       this.message = '로그인에 실패했습니다.';
  //       this.isSuccess = false;
  //     }
  //   }
  // }
  methods: {
    async login() {
      try {
        const response = await axios.post('http://localhost:3000/login', {
          email: this.email,
          password: this.password
        });

        // 로그인 성공
        this.message = `${response.data.name}님, 환영합니다!`;
        this.isSuccess = true;
      } catch (error) {
        // 로그인 실패
        if (error.response.status === 401) {
          // 비밀번호가 틀린 경우 또는 사용자가 없는 경우
          this.message = '이메일 또는 비밀번호가 잘못되었습니다.';
        } else {
          // 네트워크 오류
          console.error('로그인 오류:', error);
          this.message = '로그인에 실패했습니다.';
        }
        this.isSuccess = false;
      }
    }
  }
};
</script>

<style scoped>
.signup-page {
  max-width: 600px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-form {
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

.message-success {
  color: blue;
}
</style>

