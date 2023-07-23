-- Drop user first if they exist
DROP USER if exists 'mtgWebApp'@'%' ;

-- Now create user with prop privileges
CREATE USER 'mtgWebApp'@'%' IDENTIFIED BY 'mtgWebApp';

GRANT ALL PRIVILEGES ON * . * TO 'mtgWebApp'@'%';