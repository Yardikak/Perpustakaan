INSERT INTO categories (nama) VALUES
('Anak'),
('Komik'),
('Teknologi'),
('Novel'),
('Sejarah');
INSERT INTO books (available, judul, max_pinjam, penerbit, pengarang, tahun_terbit, kategori_id) VALUES
-- Category 1: Anak
(true, 'Charlie and the Chocolate Factory', 8, 'Penguin Random House', 'Roald Dahl', 1964, 1),
(true, 'Matilda', 8, 'Jonathan Cape', 'Roald Dahl', 1988, 1),
(true, 'The Cat in the Hat', 8, 'Random House', 'Dr. Seuss', 1957, 1),
(true, 'Harry Potter and the Philosopher\'s Stone', 8, 'Bloomsbury', 'J.K. Rowling', 1997, 1),
(true, 'The Gruffalo', 8, 'Macmillan', 'Julia Donaldson', 1999, 1),

-- Category 2: Komik
(true, 'Naruto Vol. 1', 5, 'Shueisha', 'Masashi Kishimoto', 1999, 2),
(true, 'One Piece Vol. 1', 5, 'Shueisha', 'Eiichiro Oda', 1997, 2),
(true, 'Attack on Titan Vol. 1', 5, 'Kodansha', 'Hajime Isayama', 2009, 2),
(true, 'Dragon Ball Vol. 1', 5, 'Shueisha', 'Akira Toriyama', 1984, 2),
(true, 'My Hero Academia Vol. 1', 5, 'Shueisha', 'Kohei Horikoshi', 2014, 2),

-- Category 3: Teknologi
(true, 'The Innovators', 10, 'Simon & Schuster', 'Walter Isaacson', 2014, 3),
(true, 'Clean Code', 10, 'Prentice Hall', 'Robert C. Martin', 2008, 3),
(true, 'The Pragmatic Programmer', 10, 'Addison-Wesley', 'Andrew Hunt & David Thomas', 1999, 3),
(true, 'Algorithms to Live By', 10, 'Henry Holt and Co.', 'Brian Christian & Tom Griffiths', 2016, 3),
(true, 'AI Superpowers', 10, 'Houghton Mifflin Harcourt', 'Kai-Fu Lee', 2018, 3),

-- Category 4: Novel
(true, 'To Kill a Mockingbird', 7, 'J.B. Lippincott & Co.', 'Harper Lee', 1960, 4),
(true, 'Pride and Prejudice', 7, 'T. Egerton', 'Jane Austen', 1813, 4),
(true, '1984', 7, 'Secker & Warburg', 'George Orwell', 1949, 4),
(true, 'The Great Gatsby', 7, 'Scribner', 'F. Scott Fitzgerald', 1925, 4),
(true, 'The Catcher in the Rye', 7, 'Little, Brown and Company', 'J.D. Salinger', 1951, 4),

-- Category 5: Sejarah
(true, 'Sapiens: A Brief History of Humankind', 6, 'Harvill Secker', 'Yuval Noah Harari', 2011, 5),
(true, 'Guns, Germs, and Steel', 6, 'W.W. Norton & Company', 'Jared Diamond', 1997, 5),
(true, 'The Silk Roads: A New History of the World', 6, 'Bloomsbury', 'Peter Frankopan', 2015, 5),
(true, 'A People’s History of the United States', 6, 'Harper & Row', 'Howard Zinn', 1980, 5),
(true, 'The Wright Brothers', 6, 'Simon & Schuster', 'David McCullough', 2015, 5);


INSERT INTO roles (name) VALUES
('ADMIN'),
('USER');

-- -- buat apus users perlu apus koneksi nya
-- DELETE FROM users_roles WHERE user_id = <id_user>;
