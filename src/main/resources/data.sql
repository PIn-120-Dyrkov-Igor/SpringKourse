INSERT INTO applicants (first_name, last_name, email, registration_date, status)
VALUES ('Иван', 'Иванов', 'ivan@example.com', '2023-01-01', 'Статус');

INSERT INTO recruiters (first_name, last_name, company, department)
VALUES ('Иван', 'Иванов', 'Компания', 'Найм персонала');

INSERT INTO applicantsresumes (professional_experience, education, skills, projects, certificates, status,applicant_id)
VALUES ('Профессиональный опыт', 'Образование', 'Навыки', 'Проекты', 'Сертификаты', 'Статус',1);

INSERT INTO recruiterjobs (job_title, job_description, requirements, salary, location, status,recruiter_id)
VALUES ('Название вакансии', 'Описание вакансии', 'Требования', 70000, 'Местоположение', 'Статус',1);
