CREATE TABLE IF NOT EXISTS jars ( jarid INTEGER AUTO_INCREMENT PRIMARY KEY, groupid VARCHAR(128), artifactid VARCHAR(128), version VARCHAR(128), jarname VARCHAR(256), register_date TIMESTAMP, path VARCHAR(256))

CREATE TABLE IF NOT EXISTS birthmark (birthmarkid INTEGER AUTO_INCREMENT, jarid INTEGER, birthmark_name VARCHAR(128), class_name VARCHAR(512), count INTEGER, birthmark_value VARCHAR(4096), FOREIGN KEY (jarid) REFERENCES jars (jarid) )
