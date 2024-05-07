import { createRouter, createWebHistory } from "vue-router";
import HomeView from "../views/HomeView.vue";
import SignUpPage from "@/views/SignUpPage.vue";
import LoginPage from "@/views/LoginPage.vue";
import UserListPage from "@/views/UserListPage.vue";
import CustomerListPage from "@/views/CustomerListPage.vue";
import CustomerDetailPage from "@/views/CustomerDetailPage.vue";
import CustomerEditPage from "@/views/CustomerEditPage.vue";
import UserEditPage from "@/views/UserEditPage.vue";

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/about",
    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
  },
  {
    path: "/signup", // 회원가입 페이지의 경로
    name: "SignUp",
    component: SignUpPage, // 회원가입 페이지 컴포넌트
  },
  {
    path: "/login", // 회원가입 페이지의 경로
    name: "Login",
    component: LoginPage, // 회원가입 페이지 컴포넌트
  },
  {
    path: "/users",
    name: "Users",
    component: UserListPage,
  },
  {
    path: "/customers",
    name: "Customers",
    component: CustomerListPage,
  },
  {
    path: "/customer/:id",
    name: "CustomerDetail",
    component: CustomerDetailPage,
    props: true,
  },
  {
    path: "/customer/:id/edit",
    name: "CustomerEdit",
    component: CustomerEditPage,
    props: true,
  },
  {
    path: "/users",
    name: "Users",
    component: UserListPage,
  },
  {
    path: "/users/:id/edit", // 사용자 정보 수정 페이지의 경로
    name: "UserEdit",
    component: UserEditPage, // UserEditPage 컴포넌트를 사용하여 사용자 정보 수정 페이지를 나타냄
    props: true, // 동적 매개변수를 컴포넌트의 props로 전달
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
