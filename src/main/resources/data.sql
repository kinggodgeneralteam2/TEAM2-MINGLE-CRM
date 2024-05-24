-- EMPLOYEE 데이터 삽입
INSERT INTO employee (name, email, password, authority, is_deleted)
VALUES ('김동욱', 'dongwook@test.com', 'wook123', 'MANAGER', FALSE);
INSERT INTO employee (name, email, password, authority, is_deleted)
VALUES ('장명훈', 'myeonghoon@test.com', 'hoon123', 'STAFF', FALSE);

-- CUSTOM 데이터 삽입
INSERT INTO customer (name, grade, phone, address, employee_id, memo, gender, birth)
VALUES ('권성지', 'VVIP', '010-1234-4321', 'seongji123@test.com', 1, '', 'Male', '1999-01-29');
INSERT INTO customer (name, grade, phone, address, employee_id, memo, gender, birth)
VALUES ('하지민', '신규', '010-4321-4321', 'jimin123@test.com', 1, '', 'Female', '1998-01-01');
INSERT INTO customer (name, grade, phone, address, employee_id, memo, gender, birth)
VALUES ('강찬미', '기존', '010-4132-4132', 'chanmi123@test.com', 1, '', 'Female', '2002-01-02');
INSERT INTO customer (name, grade, phone, address, employee_id, memo, gender, birth)
VALUES ('김동윽', 'VIP', '010-9876-9876', 'dongwwwwww@test.com', 2, '', 'Male', '1995-04-10');
INSERT INTO customer (name, grade, phone, address, employee_id, memo, gender, birth)
VALUES ('장띵훈', '기존', '010-3289-8903', 'thinghoon123@test.com', 2, '', 'Male', '1998-04-21');
INSERT INTO customer (name, grade, phone, address, employee_id, memo, gender, birth)
VALUES ('풀도젠깃갓리찬미', '기존', '010-3428-1342', 'fulli123@test.com', 2, '', 'Female', '2002-10-30');

INSERT INTO inquiry (customer_id, date, inquiry, type, is_reply, is_action_needed, action_content)
VALUES
    (1, '2024-05-23', '문의 내용 1', '온라인 문의', FALSE, FALSE, NULL),
    (2, '2024-05-22', '문의 내용 2', '전화 문의', TRUE, TRUE, '조치 필요'),
    (3, '2024-05-21', '문의 내용 3', '방문 문의', FALSE, TRUE, '고객 연락 필요'),
    (4, '2024-05-20', '문의 내용 4', '온라인 문의', TRUE, FALSE, NULL),
    (5, '2024-05-19', '문의 내용 5', '전화 문의', FALSE, FALSE, NULL),
    (6, '2024-05-18', '문의 내용 6', '방문 문의', TRUE, TRUE, '문제 해결'),
    (1, '2024-05-17', '문의 내용 7', '온라인 문의', FALSE, TRUE, '추가 정보 요청'),
    (2, '2024-05-16', '문의 내용 8', '전화 문의', TRUE, FALSE, NULL),
    (3, '2024-05-15', '문의 내용 9', '방문 문의', FALSE, FALSE, NULL),
    (4, '2024-05-14', '문의 내용 10', '온라인 문의', TRUE, TRUE, '고객 응답 대기');



