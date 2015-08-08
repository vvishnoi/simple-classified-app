CREATE INDEX categories_name ON categories (name);

ALTER TABLE sub_categories ADD CONSTRAINT fk_subcategory_category FOREIGN KEY (category_id) REFERENCES categories (id);
CREATE INDEX sub_categories_name ON sub_categories (name);

ALTER TABLE items ADD CONSTRAINT fk_item_subcategory FOREIGN KEY (subcategory_id) REFERENCES sub_categories (id);
CREATE INDEX items_name ON items (name);


ALTER TABLE images ADD CONSTRAINT fk__image_item FOREIGN KEY (item_id) REFERENCES items (id);