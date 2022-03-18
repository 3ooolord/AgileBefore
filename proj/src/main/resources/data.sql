INSERT INTO name (id, first_name, last_name) VALUES
(1, "Joe", "Bloggs"),
(2, "Jane", "Doe"),
(3, "A.N.", "Other"),

--
-- Indexes for table "name"
--
ALTER TABLE "name"
  ADD PRIMARY KEY ("id");

--
-- AUTO_INCREMENT for table "name"
--
ALTER TABLE "name"
  MODIFY "id" int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT; 