
CREATE TABLE categories (
  id         INTEGER IDENTITY PRIMARY KEY,
  name       VARCHAR(100)
);
CREATE INDEX categories_name ON categories (name);

CREATE TABLE sub_categories (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(100),
  category_id   INTEGER NOT NULL,
  adult BOOLEAN DEFAULT FALSE NOT NULL
);
ALTER TABLE sub_categories ADD CONSTRAINT fk_subcategory_category FOREIGN KEY (category_id) REFERENCES categories (id);
CREATE INDEX sub_categories_name ON sub_categories (name);


CREATE TABLE items (
  id   INTEGER IDENTITY PRIMARY KEY,
  name VARCHAR(500),
  subcategory_id INTEGER NOT NULL,
  detail VARCHAR(10000)
);
ALTER TABLE items ADD CONSTRAINT fk_item_subcategory FOREIGN KEY (subcategory_id) REFERENCES sub_categories (id);
CREATE INDEX items_name ON items (name);

CREATE TABLE images (
  id   INTEGER IDENTITY PRIMARY KEY,
  item_id INTEGER NOT NULL,
  url VARCHAR(1000),
  mainImage BOOLEAN DEFAULT FALSE NOT NULL
);
ALTER TABLE images ADD CONSTRAINT fk__image_item FOREIGN KEY (item_id) REFERENCES items (id);
