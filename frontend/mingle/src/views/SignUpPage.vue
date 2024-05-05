<template>
  <h1>회원가입 페이지</h1>
  <div class="signup-page">
    <SignUpForm />
  </div>
</template>

<script>
import SignUpForm from "@/components/SignUpForm.vue";

export default {
  components: {
    SignUpForm,
  },
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

h2 {
  margin-bottom: 20px;
  color: #333;
  text-align: center;
}
</style>
