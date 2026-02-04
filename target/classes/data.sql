-- ─── 초기 사용자 데이터
-- 비밀번호: admin123 (BCrypt 암호화)
INSERT INTO users (user_id, password, email, user_nm, role, is_active, created_at, updated_at) VALUES
('admin', '$2a$10$X5wFuJPBqVdXWqtVqXqHJeV.9.8LmKtWWQp.lLjLcwqvUlLgr6uZi', 'admin@example.com', '관리자', 'ADMIN', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('user1', '$2a$10$X5wFuJPBqVdXWqtVqXqHJeV.9.8LmKtWWQp.lLjLcwqvUlLgr6uZi', 'user@example.com', '일반사용자', 'USER', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- ─── 초기 제품 데이터
INSERT INTO products (name, description, price, stock, category, image_url, is_active, created_at, updated_at) VALUES
('MacBook Pro 16', '최신 M3 Max 칩셋을 탑재한 강력한 노트북', 3500000, 15, '전자제품', 'https://via.placeholder.com/300x200?text=MacBook', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('iPhone 15 Pro', '티타늄 디자인과 A17 Pro 칩셋', 1500000, 50, '전자제품', 'https://via.placeholder.com/300x200?text=iPhone', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('AirPods Pro 2', '적응형 오디오와 향상된 노이즈 캔슬링', 350000, 100, '전자제품', 'https://via.placeholder.com/300x200?text=AirPods', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('iPad Air', '10.9인치 Liquid Retina 디스플레이', 850000, 30, '전자제품', 'https://via.placeholder.com/300x200?text=iPad', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Magic Keyboard', '백라이트 키와 숫자 키패드', 180000, 45, '액세서리', 'https://via.placeholder.com/300x200?text=Keyboard', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Magic Mouse', '멀티터치 표면과 충전식 배터리', 120000, 60, '액세서리', 'https://via.placeholder.com/300x200?text=Mouse', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('LG 그램 17', '초경량 17인치 노트북', 2100000, 20, '전자제품', 'https://via.placeholder.com/300x200?text=LG+Gram', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Galaxy Tab S9', '11인치 AMOLED 디스플레이 태블릿', 950000, 25, '전자제품', 'https://via.placeholder.com/300x200?text=Galaxy+Tab', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Sony WH-1000XM5', '업계 최고의 노이즈 캔슬링 헤드폰', 450000, 40, '오디오', 'https://via.placeholder.com/300x200?text=Sony+Headphone', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Dell UltraSharp 27', '4K UHD 모니터', 680000, 18, '모니터', 'https://via.placeholder.com/300x200?text=Dell+Monitor', true, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
