<template>
  <div>
    <h1>고객 관리</h1>
    <CustomerList />
  </div>
</template>

<script>
import CustomerList from "@/components/CustomerList.vue";

export default {
  components: {
    CustomerList,
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
