CREATE TABLE IF NOT EXISTS Authors(
		author_id INTEGER NOT NULL,
		first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        birth_year INTEGER,
		PRIMARY KEY (author_id)
);

CREATE TABLE IF NOT EXISTS Members(
		member_id INTEGER NOT NULL,
		first_name VARCHAR(30) NOT NULL,
        last_name VARCHAR(30) NOT NULL,
        email VARCHAR(50),
        join_date DATE,
		PRIMARY KEY (member_id)
);

CREATE TABLE IF NOT EXISTS Books(
		book_id INTEGER NOT NULL AUTO_INCREMENT,
        author_id INTEGER NOT NULL,
		title VARCHAR(60) NOT NULL,
        genre VARCHAR(30),
        publish_year INTEGER,
        copies_total INTEGER,
        copies_available INTEGER,
		PRIMARY KEY (book_id),
        FOREIGN KEY (author_id)
        REFERENCES Authors(author_id)
);

CREATE TABLE IF NOT EXISTS Loans(
		loan_id INTEGER NOT NULL AUTO_INCREMENT,
        member_id INTEGER NOT NULL,
        book_id INTEGER NOT NULL,
        loan_date DATE,
        due_date DATE,
        return_date DATE,
		PRIMARY KEY (loan_id),
        FOREIGN KEY (member_id)
        REFERENCES Members(member_id),
        FOREIGN KEY (book_id)
        REFERENCES Books(book_id)
);

SHOW TABLES;

