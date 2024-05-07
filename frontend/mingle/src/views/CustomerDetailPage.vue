<template>
  <div>
    <h1>고객 관리</h1>
    <CustomerDetail />
  </div>
</template>

<script>
import CustomerDetail from "@/components/CustomerDetail.vue";

export default {
  components: {
    CustomerDetail,
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
