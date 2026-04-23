ALTER TABLE doctors ADD enable TINYINT;
UPDATE doctors SET enable = 1;