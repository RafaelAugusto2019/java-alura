ALTER TABLE appointments ADD enable TINYINT;
UPDATE appointments SET enable = 1;