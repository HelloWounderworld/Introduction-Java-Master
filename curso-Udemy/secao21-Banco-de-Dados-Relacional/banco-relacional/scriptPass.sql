-- Na parte onde está escrito user, vc substitui para o nome de usuário que vc está usando no MySQL
-- Na parte do 'pass' vc altera para a senha que vc deseja colocar para conseguir acessar o banco de dados.
SET GLOBAL validate_password.LENGTH = 4;
SET GLOBAL validate_password.policy = 0;
SET GLOBAL validate_password.mixed_case_count = 0;
SET GLOBAL validate_password.number_count = 0;
SET GLOBAL validate_password.special_char_count = 0;
SET GLOBAL validate_password.check_user_name = 0;
ALTER USER 'user'@'localhost' IDENTIFIED BY 'pass';
FLUSH PRIVILEGES;