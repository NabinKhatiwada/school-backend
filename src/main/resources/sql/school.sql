CREATE TABLE tbl_level(
	id int primary key auto_increment,
	name varchar(100) UNIQUE NOT NULL
);

CREATE TABLE tbl_section(
	id int primary key auto_increment,
	name varchar(100) NOT NULL,
	level_id int NOT NULL,
	CONSTRAINT FK_Section_Level FOREIGN KEY (level_id) REFERENCES tbl_level(id),
	CONSTRAINT UK_Section_Level UNIQUE(name, level_id)
);

CREATE TABLE tbl_student(
	id varchar(255) primary key,
    active bit(1) NOT NULL,
	created_datetime datetime NOT NULL,
	updated_datetime datetime NOT NULL,
	name varchar(100) NOT NULL, 
	roll_no int NOT NULL,
	level_id int NOT NULL,
	section_id int NOT NULL,
	parent_name varchar(100) NOT NULL,
	parent_relation varchar(50) NOT NULL,
	phone_number varchar(10),
	email varchar(100),
	age int,
	gender varchar(10) NOT NULL,
	religion varchar(50),
	address varchar(255) NOT NULL,
	vegetarian_fLag bit(1) NOT NULL,
	vehicle_flag bit(1) NOT NULL,
    CONSTRAINT FK_Student_Level FOREIGN KEY (level_id) REFERENCES tbl_level(id),
	CONSTRAINT FK_Student_Section FOREIGN KEY (section_id) REFERENCES tbl_section(id)
);

create table tbl_achedemic_fee(
	id varchar(255) primary key,
    active bit(1) NOT NULL,
	created_datetime datetime NOT NULL,
	updated_datetime datetime NOT NULL,
    level_id int,
    monthly_fee decimal(8,2),
    admission_fee decimal(8,2),
    exam_fee decimal(8,2),
    vehicle_fee decimal(8,2),
    tie_fee decimal(8,2),
    belt_fee decimal(8,2),
    annual_fee decimal(8,2),
    food_fee decimal(8,2),
    sports_fee decimal(8,2),
    computer_fee decimal(8,2),
    learning_materials_fee decimal(8,2),
    others_fee decimal(8,2),
	CONSTRAINT FK_Achedemic_Fee_Level FOREIGN KEY (level_id) REFERENCES tbl_level(id)
);

create table tbl_student_bill(
	id varchar(255) primary key,
    active bit(1) NOT NULL,
	created_datetime datetime NOT NULL,
	updated_datetime datetime NOT NULL,
    level_id int,
    achedemic_fee_id varchar(255),
    student_id varchar(255),
    monthly_fee decimal(8,2),
	scholarship_percentage decimal(5,2),
	admission_fee decimal(8,2),
    exam_fee decimal(8,2),
    vehicle_fee decimal(8,2),
    tie_fee decimal(8,2),
    belt_fee decimal(8,2),
    annual_fee decimal(8,2),
    food_fee decimal(8,2),
    sports_fee decimal(8,2),
    computer_fee decimal(8,2),
    learning_materials_fee decimal(8,2),
    others_fee decimal(8,2),
    total_Amount decimal(8,2),
    discount_amount decimal(8,2),
    previous_balance decimal(8,2),
    net_amount decimal(8,2),
    amount_received decimal(8,2),
    balance decimal(8,2),
    remarks varchar(255),
    
    CONSTRAINT FK_Achedemic_Fee_Level FOREIGN KEY (level_id) REFERENCES tbl_level(id),
	CONSTRAINT FK_Student_Bill_Achemedic_Fee FOREIGN KEY (achedemic_fee_id) REFERENCES tbl_achedemic_fee(id),
	CONSTRAINT FK_Achedemic_Fee_Student FOREIGN KEY (student_id) REFERENCES tbl_student(id)
);