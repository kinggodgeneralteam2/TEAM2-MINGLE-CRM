<template>
  <div class="login-page">
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
    <!-- 로그인 성공 시 회원 정보 수정 버튼 -->
    <button v-if="isSuccess" @click="goToUpdatePage">회원 정보 수정</button>
  </div>
</template>

<script>
import { useAuthStore } from '../storage/auth';
import { ref } from 'vue';
import axios from 'axios';

export default {
  setup() {
    const authStore = useAuthStore(); // Pinia Store 불러오기

    const email = ref(''); // 이메일
    const password = ref(''); // 비밀번호
    const message = ref(''); // 로그인 결과 메시지
    const isSuccess = ref(false); // 로그인 성공 여부
    // const userId = ref(null); // 로그인한 사용자의 ID

    // 로그인 함수
    const login = async () => {
      try {
        // 서버에서 사용자 정보 가져오기
        const response = await axios.post('http://localhost:8080/api/v1/auth/signin', {
          email: email.value,
          password: password.value
        });

        const tokens = response.data;

        // Pinia Store에 토큰 설정
        authStore.setTokens(tokens.atk, tokens.rtk);

        // AccessToken 저장
        localStorage.setItem('accessToken', tokens.atk);

        // RefreshToken 저장 (HTTP Only 쿠키)
        document.cookie = `refreshToken=${tokens.rtk}; Secure; SameSite=Strict;`;

        // 로그인 성공 메시지 표시
        message.value = '로그인에 성공했습니다.';
        isSuccess.value = true;

        console.log("tokens", tokens);

      } catch (error) {
        // 네트워크 오류 메시지 표시
        console.error('로그인 오류:', error);
        message.value = '로그인에 실패했습니다.';
        isSuccess.value = false;
      }
    };

    // 회원 정보 수정 페이지로 이동 함수
    const goToUpdatePage = () => {
      // 로그인한 사용자의 ID를 사용하여 회원 정보 수정 페이지로 이동
      // 여기서는 this를 사용하지 않아야 합니다.
      // 대신에 router를 직접 import하여 사용해야 합니다.
      // 아래의 코드는 예시이며, 사용 중인 라우터에 따라 수정해야 합니다.
      // import { useRouter } from 'vue-router';
      // const router = useRouter();
      // router.push({ name: 'UserEdit', params: { id: userId.value } });
    };

    return { email, password, message, isSuccess, login, goToUpdatePage };
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

