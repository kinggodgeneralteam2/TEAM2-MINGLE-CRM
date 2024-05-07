<template>
  <div>
    <h2>회원가입</h2>
    <form @submit.prevent="signUp" class="signup-form">
      <div class="form-group">
        <label for="email">이메일</label>
        <input id="email" v-model="email" type="email" required @input="validateEmail">
        <p class="email-message" :style="{ color: isEmailValid ? 'blue' : 'red' }">{{ emailMessage }}</p>
      </div>
      <div class="form-group">
        <label for="name">이름</label>
        <input id="name" v-model="name" type="text" required>
      </div>
      <div class="form-group">
        <label for="phone">전화번호</label>
        <input id="phone" v-model="phone" type="tel" required @input="validatePhone">
        <p class="phone-message" :style="{ color: isPhoneValid ? 'blue' : 'red' }">{{ phoneMessage }}</p>
      </div>
      <div class="form-group">
        <label for="password">비밀번호</label>
        <input id="password" v-model="password" type="password" required @input="validatePassword">
        <p class="password-message" :style="{ color: isPasswordValid ? 'blue' : 'red' }">{{ passwordMessage }}</p>
      </div>
      <!-- 유효성 메시지 표시 -->
      <button type="submit" class="btn-submit" :disabled="!isPasswordValid">회원가입</button>
    </form>
    <p v-if="message" class="message">{{ message }}</p>
  </div>
</template>

<script>
import axios from 'axios';
import router from "@/router";

export default {
  data() {
    return {
      email: '',
      name: '',
      phone: '',
      password: '',
      message: '',
      passwordMessage: '',
      emailMessage: '',
      phoneMessage: '',
      isPasswordValid: false,
      isEmailValid: false,
      isPhoneValid: false
    };
  },
  methods: {
    async signUp() {
      // 빈칸 검사
      if (!this.email || !this.name || !this.phone || !this.password) {
        console.log("빈칸 검사에서 window.alert() 호출됨");
        window.alert('모든 항목을 입력해주세요.');
        return;
      }

      // 비밀번호 유효성 검사 업데이트
      this.validatePassword();

      // 비밀번호 유효성 검사
      if (!this.isPasswordValid) {
        console.log("비밀번호 유효성 검사에서 window.alert() 호출됨");
        window.alert('비밀번호를 정확히 입력해주세요.');
        return; // 비밀번호가 유효하지 않으면 회원가입 진행하지 않음
      }

      // 이메일 유효성 검사
      if (!this.isEmailValid) {
        console.log("이메일 유효성 검사에서 window.alert() 호출됨");
        window.alert('이메일 주소를 정확히 입력해주세요.');
        return;
      }

      // 전화번호 유효성 검사
      if (!this.isPhoneValid) {
        window.alert('전화번호를 정확히 입력해주세요.');
        return;
      }

      try {
        const response = await axios.post('http://localhost:8080/api/v1/auth/signup', {
          email: this.email,
          name: this.name,
          phone: this.phone,
          password: this.password
        });
        alert(`${this.name}님, 환영합니다! 회원가입이 성공적으로 완료되었습니다.`);
        this.message = response.data.message;
        // 회원가입 성공 시 로그인 페이지로 이동합니다.
        await router.push('/login');
        // await : router.push 비동기 함수 -> Promise를 반환 -> 회원가입 요청이 성공적으로 처리되고, 회원가입 성공 메시지가 표시된 후에만 로그인 페이지로 이동
      } catch (error) {
        if (error.response) {
          this.message = error.response.data.message;
        } else {
          this.message = '네트워크 오류: 서버에 연결할 수 없습니다.';
        }
      }
    },
    // 비밀번호 유효성 검사 함수
    validatePassword() {
      const passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,16}$/;
      if (!passwordPattern.test(this.password)) {
        this.passwordMessage = '영문, 숫자, 대문자, 특수문자를 조합하여 8-16자로 입력해주세요.';
        this.isPasswordValid = false;
      } else {
        this.passwordMessage = '올바른 비밀번호입니다.';
        this.isPasswordValid = true;
      }
    },
    // 이메일 유효성 검사 함수
    validateEmail() {
      const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
      if (!emailPattern.test(this.email)) {
        this.emailMessage = '올바른 이메일 주소를 입력해주세요.';
        this.isEmailValid = false;
      } else {
        this.emailMessage = '올바른 이메일 주소입니다.';
        this.isEmailValid = true;
      }
    },
    // 전화번호 유효성 검사 함수
    validatePhone() {
      const phonePattern = /^\d{3}\d{4}\d{4}$/;
      if (!phonePattern.test(this.phone)) {
        this.phoneMessage = '올바른 전화번호 형식을 입력해주세요. (000-0000-0000)';
        this.isPhoneValid = false;
      } else {
        this.phoneMessage = '올바른 전화번호 형식입니다.';
        this.isPhoneValid = true;
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

.password-message {
  margin-top: 5px;
}
</style>
