-- -- User 데이터 삽입
-- INSERT INTO users (name, email, password, authority, deleted_yn) VALUES ('John Doe', 'john.doe@example.com', 'password123', 'MANAGER', false);
-- INSERT INTO users (name, email, password, authority, deleted_yn) VALUES ('Jane Doe', 'jane.doe@example.com', 'password456', 'STAFF', false);
--
-- -- Customer 데이터 삽입
-- INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
-- VALUES ('Alice Johnson', 'VIP', '123-456-7890', '1234 Elm St, Somewhere', 1, 'Important client', 'Female', '1985-07-20');
-- INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
-- VALUES ('Bob Brown', '기존', '987-654-3210', '5678 Oak St, Anywhere', 1, 'Frequent orders', 'Male', '1990-12-15');
-- INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
-- VALUES ('Carol White', '기존', '456-789-0123', '9012 Maple St, Nowhere', 1, 'Rare visits', 'Female', '1992-05-30');
-- INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
-- VALUES ('David Smith', 'VIP', '321-654-9870', '3456 Pine St, Elsewhere', 2, 'High spender', 'Male', '1980-08-25');
-- INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
-- VALUES ('Eve Black', '신규', '654-321-7890', '7890 Ash St, Somewhere', 2, 'Medium spender', 'Female', '1988-03-15');
-- INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
-- VALUES ('Frank Moore', '신규', '789-012-3456', '1234 Birch St, Anywhere', 2, 'Potential VIP', 'Male', '1995-07-07');

-- USER 데이터 삽입
INSERT INTO users (name, email, password, authority, deleted_yn)
VALUES ('김동욱', 'dongwook@test.com', 'wook123', 'MANAGER', FALSE);
INSERT INTO users (name, email, password, authority, deleted_yn)
VALUES ('장명훈', 'myeonghoon@test.com', 'hoon123', 'STAFF', FALSE);

-- CUSTOM 데이터 삽입
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
VALUES ('권성지', 'VVIP', '010-1234-4321', 'seongji123@test.com', 1, '', 'Male', '1999-01-29');
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
VALUES ('하지민', '신규', '010-4321-4321', 'jimin123@test.com', 1, '', 'Female', '1998-01-01');
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
VALUES ('강찬미', '기존', '010-4132-4132', 'chanmi123@test.com', 1, '', 'Female', '2002-01-02');
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
VALUES ('김동윽', 'VIP', '010-9876-9876', 'dongwwwwww@test.com', 2, '', 'Male', '1995-04-10');
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
VALUES ('장띵훈', '기존', '010-3289-8903', 'thinghoon123@test.com', 2, '', 'Male', '1998-04-21');
INSERT INTO customer (name, customer_group, phone, address, user_id, memo, gender, birth)
VALUES ('풀도젠깃갓리찬미', '기존', '010-3428-1342', 'fulli123@test.com', 2, '', 'Female', '2002-10-30');
