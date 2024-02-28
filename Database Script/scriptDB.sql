CREATE TABLE "tbl_account" (
  "account_id" int NOT NULL AUTO_INCREMENT,
  "email" varchar(255) DEFAULT NULL,
  "password" varchar(255) DEFAULT NULL,
  "reported_count" int NOT NULL,
  "status" varchar(255) DEFAULT NULL,
  "roleid" int DEFAULT NULL,
  PRIMARY KEY ("account_id"),
  KEY "FKeiam3xdbf6kablaxd1vq006e2" ("roleid"),
  CONSTRAINT "FKeiam3xdbf6kablaxd1vq006e2" FOREIGN KEY ("roleid") REFERENCES "tbl_role" ("role_id")
);

CREATE TABLE "tbl_account_rooms" (
  "accountdto_account_id" int NOT NULL,
  "rooms_id" int NOT NULL,
  PRIMARY KEY ("accountdto_account_id","rooms_id"),
  KEY "FKisplurk67yfxdnkkbf8xv9e5g" ("rooms_id"),
  CONSTRAINT "FK5e28mud9vb9lofcmr8ypwoe17" FOREIGN KEY ("accountdto_account_id") REFERENCES "tbl_account" ("account_id"),
  CONSTRAINT "FKisplurk67yfxdnkkbf8xv9e5g" FOREIGN KEY ("rooms_id") REFERENCES "tbl_room" ("id")
);

CREATE TABLE "tbl_addingproductrequest" (
  "addproduct_id" int NOT NULL AUTO_INCREMENT,
  "createdt_date" date DEFAULT NULL,
  "description" varchar(255) DEFAULT NULL,
  "status" varchar(255) DEFAULT NULL,
  "productid" int DEFAULT NULL,
  PRIMARY KEY ("addproduct_id"),
  UNIQUE KEY "UK_2k459vcjmqaiwikg6icxx95tc" ("productid"),
  CONSTRAINT "FK3duuet9qbpy7cukem4qi3fwtx" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid")
);

CREATE TABLE "tbl_address" (
  "address_id" int NOT NULL AUTO_INCREMENT,
  "address" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "customerid" int DEFAULT NULL,
  PRIMARY KEY ("address_id"),
  KEY "FK1i2l5iyu3yj4padwlku54gehl" ("customerid"),
  CONSTRAINT "FK1i2l5iyu3yj4padwlku54gehl" FOREIGN KEY ("customerid") REFERENCES "tbl_customer" ("customer_id")
);

CREATE TABLE "tbl_category" (
  "categoryid" int NOT NULL AUTO_INCREMENT,
  "category_name" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY ("categoryid")
);

CREATE TABLE "tbl_customer" (
  "customer_id" int NOT NULL AUTO_INCREMENT,
  "avatar_url" varchar(255) DEFAULT NULL,
  "full_name" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "phone" varchar(255) DEFAULT NULL,
  "sex" bit(1) NOT NULL,
  "account_id" int DEFAULT NULL,
  PRIMARY KEY ("customer_id"),
  UNIQUE KEY "UK_fyu2t8hyyp3iniqt3r6d4ilr9" ("account_id"),
  CONSTRAINT "FKmnut5john0j7sjopc7b3h2gyt" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id")
);

CREATE TABLE "tbl_favoriteproduct" (
  "favoriteproduct_id" int NOT NULL AUTO_INCREMENT,
  "status" varchar(255) DEFAULT NULL,
  "customer_id" int DEFAULT NULL,
  "productid" int DEFAULT NULL,
  PRIMARY KEY ("favoriteproduct_id"),
  KEY "FK96qntaoqswmeutq3niugirtga" ("customer_id"),
  KEY "FK3vi5doajhmxty0pninetc8k5a" ("productid"),
  CONSTRAINT "FK3vi5doajhmxty0pninetc8k5a" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid"),
  CONSTRAINT "FK96qntaoqswmeutq3niugirtga" FOREIGN KEY ("customer_id") REFERENCES "tbl_customer" ("customer_id")
);

CREATE TABLE "tbl_feedback" (
  "feedback_id" int NOT NULL AUTO_INCREMENT,
  "createdt_date" date DEFAULT NULL,
  "description" varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "customer_id" int DEFAULT NULL,
  "productid" int DEFAULT NULL,
  "rating_point" int NOT NULL,
  PRIMARY KEY ("feedback_id"),
  KEY "FKb0unhbjn75mliko4mfl9pknxq" ("customer_id"),
  KEY "FKdeuwmafitvi4j28ebx06rd9pt" ("productid"),
  CONSTRAINT "FKb0unhbjn75mliko4mfl9pknxq" FOREIGN KEY ("customer_id") REFERENCES "tbl_customer" ("customer_id"),
  CONSTRAINT "FKdeuwmafitvi4j28ebx06rd9pt" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid")
);

CREATE TABLE "tbl_feedbackimg" (
  "feedbackimg_id" int NOT NULL AUTO_INCREMENT,
  "img_url" varchar(255) DEFAULT NULL,
  "feedback_id" int DEFAULT NULL,
  PRIMARY KEY ("feedbackimg_id"),
  KEY "FKiisjv41ytnccecgvuwjw6joyy" ("feedback_id"),
  CONSTRAINT "FKiisjv41ytnccecgvuwjw6joyy" FOREIGN KEY ("feedback_id") REFERENCES "tbl_feedback" ("feedback_id")
);

CREATE TABLE "tbl_message" (
  "id" int NOT NULL AUTO_INCREMENT,
  "message" varchar(255) DEFAULT NULL,
  "account_id" int DEFAULT NULL,
  "room_id" int DEFAULT NULL,
  "create_at" datetime DEFAULT NULL,
  PRIMARY KEY ("id"),
  KEY "FKruc1gfi7nfvnkxecpoxec5l5d" ("account_id"),
  KEY "FK240k54csbuahxpoamqbetvn7s" ("room_id"),
  CONSTRAINT "FK240k54csbuahxpoamqbetvn7s" FOREIGN KEY ("room_id") REFERENCES "tbl_room" ("id"),
  CONSTRAINT "FKruc1gfi7nfvnkxecpoxec5l5d" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id")
);

CREATE TABLE "tbl_orderbuy" (
  "orderbuy_id" int NOT NULL AUTO_INCREMENT,
  "customer_address" varchar(255) DEFAULT NULL,
  "date_order" datetime DEFAULT NULL,
  "order_code" varchar(255) DEFAULT NULL,
  "shippingfee" double NOT NULL,
  "status" varchar(255) DEFAULT NULL,
  "total" double NOT NULL,
  "total_buy_price_product" double NOT NULL,
  "customer_id" int DEFAULT NULL,
  "productowner_id" int DEFAULT NULL,
  "voucher_id" int DEFAULT NULL,
  PRIMARY KEY ("orderbuy_id"),
  KEY "FKrvvnj8eq8kk76v88kna1s631y" ("customer_id"),
  KEY "FK40q0gl0fkd8yoxf46jpsm04lt" ("productowner_id"),
  KEY "FKf7xqhhlc0s4xvunv2wd1tlxvk" ("voucher_id"),
  CONSTRAINT "FK40q0gl0fkd8yoxf46jpsm04lt" FOREIGN KEY ("productowner_id") REFERENCES "tbl_productowner" ("productowner_id"),
  CONSTRAINT "FKf7xqhhlc0s4xvunv2wd1tlxvk" FOREIGN KEY ("voucher_id") REFERENCES "tbl_voucher" ("voucher_id"),
  CONSTRAINT "FKrvvnj8eq8kk76v88kna1s631y" FOREIGN KEY ("customer_id") REFERENCES "tbl_customer" ("customer_id")
);

CREATE TABLE "tbl_orderbuydetail" (
  "orderbuydetail_id" int NOT NULL AUTO_INCREMENT,
  "price" double NOT NULL,
  "orderbuy_id" int DEFAULT NULL,
  "productid" int DEFAULT NULL,
  PRIMARY KEY ("orderbuydetail_id"),
  KEY "FK5wd7mqatrdc53wi6wac4ypvsi" ("orderbuy_id"),
  KEY "FK2bye8rpk0ar3pxjkrrc2aguid" ("productid"),
  CONSTRAINT "FK2bye8rpk0ar3pxjkrrc2aguid" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid"),
  CONSTRAINT "FK5wd7mqatrdc53wi6wac4ypvsi" FOREIGN KEY ("orderbuy_id") REFERENCES "tbl_orderbuy" ("orderbuy_id")
);

CREATE TABLE "tbl_orderrent" (
  "orderrent_id" int NOT NULL AUTO_INCREMENT,
  "coc_money_total" double NOT NULL,
  "customer_address" varchar(255) DEFAULT NULL,
  "date_order" datetime DEFAULT NULL,
  "order_code" varchar(255) DEFAULT NULL,
  "shipping_fee" double NOT NULL,
  "status" varchar(255) DEFAULT NULL,
  "total" double NOT NULL,
  "total_rent_price_product" double NOT NULL,
  "customer_id" int DEFAULT NULL,
  "productowner_id" int DEFAULT NULL,
  "voucher_id" int DEFAULT NULL,
  "returning_date" int NOT NULL,
  "is_feed_back" bit(1) NOT NULL,
  PRIMARY KEY ("orderrent_id"),
  KEY "FK99v044k3e017t5abapboso1by" ("customer_id"),
  KEY "FKeny90hvtfeu0mb0gw8yb3fxy4" ("productowner_id"),
  KEY "FKmpq380tqh6xexcs9lwu6oifch" ("voucher_id"),
  CONSTRAINT "FK99v044k3e017t5abapboso1by" FOREIGN KEY ("customer_id") REFERENCES "tbl_customer" ("customer_id"),
  CONSTRAINT "FKeny90hvtfeu0mb0gw8yb3fxy4" FOREIGN KEY ("productowner_id") REFERENCES "tbl_productowner" ("productowner_id"),
  CONSTRAINT "FKmpq380tqh6xexcs9lwu6oifch" FOREIGN KEY ("voucher_id") REFERENCES "tbl_voucher" ("voucher_id")
);

CREATE TABLE "tbl_orderrentdetail" (
  "orderrentdetail_id" int NOT NULL AUTO_INCREMENT,
  "coc_money" double NOT NULL,
  "end_date" date DEFAULT NULL,
  "rent_price" double NOT NULL,
  "start_date" date DEFAULT NULL,
  "orderrent_id" int DEFAULT NULL,
  "productid" int DEFAULT NULL,
  "remaining_date" bigint NOT NULL,
  PRIMARY KEY ("orderrentdetail_id"),
  KEY "FKhutgvu1vj2erw76madeiyibmx" ("orderrent_id"),
  KEY "FKyc2sud4xxt8akofu32hxxo8g" ("productid"),
  CONSTRAINT "FKhutgvu1vj2erw76madeiyibmx" FOREIGN KEY ("orderrent_id") REFERENCES "tbl_orderrent" ("orderrent_id"),
  CONSTRAINT "FKyc2sud4xxt8akofu32hxxo8g" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid")
);

CREATE TABLE "tbl_product" (
  "productid" int NOT NULL AUTO_INCREMENT,
  "check_type" varchar(255) DEFAULT NULL,
  "description" varchar(500) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "price" double NOT NULL,
  "product_avt" varchar(255) DEFAULT NULL,
  "product_condition" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "product_name" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "product_receipt_url" varchar(255) DEFAULT NULL,
  "product_specification_data" json DEFAULT NULL,
  "serial_number" varchar(255) DEFAULT NULL,
  "status" varchar(255) DEFAULT NULL,
  "term" varchar(2000) DEFAULT NULL,
  "categoryid" int DEFAULT NULL,
  "productowner_id" int DEFAULT NULL,
  PRIMARY KEY ("productid"),
  KEY "FKkwcmxfbd3ukpimruossrwyscm" ("categoryid"),
  KEY "FK8quvl9pqqfpi2ryu7uxyas0h9" ("productowner_id"),
  CONSTRAINT "FK8quvl9pqqfpi2ryu7uxyas0h9" FOREIGN KEY ("productowner_id") REFERENCES "tbl_productowner" ("productowner_id"),
  CONSTRAINT "FKkwcmxfbd3ukpimruossrwyscm" FOREIGN KEY ("categoryid") REFERENCES "tbl_category" ("categoryid")
);

CREATE TABLE "tbl_productdetail" (
  "productdetail_id" int NOT NULL AUTO_INCREMENT,
  "detail_name" varchar(255) DEFAULT NULL,
  "value" varchar(255) DEFAULT NULL,
  "productid" int DEFAULT NULL,
  PRIMARY KEY ("productdetail_id"),
  KEY "FK5a1ekdksldinl06n7avnd73xg" ("productid"),
  CONSTRAINT "FK5a1ekdksldinl06n7avnd73xg" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid")
);

CREATE TABLE "tbl_productimg" (
  "productimg_id" int NOT NULL AUTO_INCREMENT,
  "img_url" varchar(255) DEFAULT NULL,
  "productid" int DEFAULT NULL,
  PRIMARY KEY ("productimg_id"),
  KEY "FKbwu8pefcpffbn9w9iwr5wy16b" ("productid"),
  CONSTRAINT "FKbwu8pefcpffbn9w9iwr5wy16b" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid")
);

CREATE TABLE "tbl_productowner" (
  "productowner_id" int NOT NULL AUTO_INCREMENT,
  "poshopid" int NOT NULL,
  "potoken" varchar(255) DEFAULT NULL,
  "address" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "avatar_url" varchar(255) DEFAULT NULL,
  "full_name" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "phone" varchar(255) DEFAULT NULL,
  "account_id" int DEFAULT NULL,
  "reputation_point" int NOT NULL,
  PRIMARY KEY ("productowner_id"),
  KEY "FKnao9pft55hpjg9phx7565ma5h" ("account_id"),
  CONSTRAINT "FKnao9pft55hpjg9phx7565ma5h" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id")
);

CREATE TABLE "tbl_productrentalprices" (
  "productrentalprices_id" int NOT NULL AUTO_INCREMENT,
  "mock_day" int NOT NULL,
  "rent_price" double NOT NULL,
  "productid" int DEFAULT NULL,
  PRIMARY KEY ("productrentalprices_id"),
  KEY "FK7we7swjmjgaib2o1molu4mk6x" ("productid"),
  CONSTRAINT "FK7we7swjmjgaib2o1molu4mk6x" FOREIGN KEY ("productid") REFERENCES "tbl_product" ("productid")
);

CREATE TABLE "tbl_rentalproductimg" (
  "rentalproductimg_id" int NOT NULL AUTO_INCREMENT,
  "created_date" date DEFAULT NULL,
  "product_img" varchar(255) DEFAULT NULL,
  "status" varchar(255) DEFAULT NULL,
  "account_id" int DEFAULT NULL,
  "orderrent_id" int DEFAULT NULL,
  PRIMARY KEY ("rentalproductimg_id"),
  KEY "FKpm1ingmtqc4nb7m32fdiqagkr" ("account_id"),
  KEY "FK9cc00isqn8d3x93jm2mxv9t5x" ("orderrent_id"),
  CONSTRAINT "FK9cc00isqn8d3x93jm2mxv9t5x" FOREIGN KEY ("orderrent_id") REFERENCES "tbl_orderrent" ("orderrent_id"),
  CONSTRAINT "FKpm1ingmtqc4nb7m32fdiqagkr" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id")
);

CREATE TABLE "tbl_requestcomplainingorder" (
  "requestcomplainingorder_id" int NOT NULL AUTO_INCREMENT,
  "createdt_date" date DEFAULT NULL,
  "description" varchar(255) DEFAULT NULL,
  "expected_cost" double NOT NULL,
  "staff_response" varchar(255) DEFAULT NULL,
  "status" varchar(255) DEFAULT NULL,
  "orderbuy_id" int DEFAULT NULL,
  "orderrent_id" int DEFAULT NULL,
  "productowner_id" int DEFAULT NULL,
  PRIMARY KEY ("requestcomplainingorder_id"),
  KEY "FKjhliofp6rwuil4w18bf36edc4" ("orderbuy_id"),
  KEY "FK2g7sr0wfuk3kesid4oxryhrgp" ("orderrent_id"),
  KEY "FKiv3beajbj3u4gx1uwxvp503lc" ("productowner_id"),
  CONSTRAINT "FK2g7sr0wfuk3kesid4oxryhrgp" FOREIGN KEY ("orderrent_id") REFERENCES "tbl_orderrent" ("orderrent_id"),
  CONSTRAINT "FKiv3beajbj3u4gx1uwxvp503lc" FOREIGN KEY ("productowner_id") REFERENCES "tbl_productowner" ("productowner_id"),
  CONSTRAINT "FKjhliofp6rwuil4w18bf36edc4" FOREIGN KEY ("orderbuy_id") REFERENCES "tbl_orderbuy" ("orderbuy_id")
);

CREATE TABLE "tbl_role" (
  "role_id" int NOT NULL AUTO_INCREMENT,
  "role_name" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("role_id")
);

CREATE TABLE "tbl_room" (
  "id" int NOT NULL AUTO_INCREMENT,
  "name" varchar(255) DEFAULT NULL,
  "last_updated" datetime DEFAULT NULL,
  "last_message" varchar(255) DEFAULT NULL,
  PRIMARY KEY ("id")
);

CREATE TABLE "tbl_room_accounts" (
  "roomdto_id" int NOT NULL,
  "accounts_account_id" int NOT NULL,
  PRIMARY KEY ("roomdto_id","accounts_account_id"),
  KEY "FK8cx85l79yygty7torytjfxg8f" ("accounts_account_id"),
  CONSTRAINT "FK8cx85l79yygty7torytjfxg8f" FOREIGN KEY ("accounts_account_id") REFERENCES "tbl_account" ("account_id"),
  CONSTRAINT "FKnfy64w4i5o7moi3rw4q4dtbf8" FOREIGN KEY ("roomdto_id") REFERENCES "tbl_room" ("id")
);

CREATE TABLE "tbl_staff" (
  "staff_id" int NOT NULL AUTO_INCREMENT,
  "avatar_url" varchar(255) DEFAULT NULL,
  "full_name" varchar(255) DEFAULT NULL,
  "account_id" int DEFAULT NULL,
  PRIMARY KEY ("staff_id"),
  UNIQUE KEY "UK_ftasosia4p60pwek0b61a2p32" ("account_id"),
  CONSTRAINT "FKbyj4ctv34hlyfw0so0b3sj13o" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id")
);

CREATE TABLE "tbl_staffrequested" (
  "staffrequested_id" int NOT NULL AUTO_INCREMENT,
  "created_date" date DEFAULT NULL,
  "addproduct_id" int DEFAULT NULL,
  "requestcomplainingorder_id" int DEFAULT NULL,
  "staff_id" int DEFAULT NULL,
  PRIMARY KEY ("staffrequested_id"),
  UNIQUE KEY "UK_3gtnslimtm1yuypkyyp2d7ycm" ("addproduct_id"),
  UNIQUE KEY "UK_4dujnonkinmmsx2hp29lmy962" ("requestcomplainingorder_id"),
  KEY "FK1yu593cvqx9hyqajbn50pggg1" ("staff_id"),
  CONSTRAINT "FK1yu593cvqx9hyqajbn50pggg1" FOREIGN KEY ("staff_id") REFERENCES "tbl_staff" ("staff_id"),
  CONSTRAINT "FK4jabhijxqgi2xoxwlsq686xxa" FOREIGN KEY ("requestcomplainingorder_id") REFERENCES "tbl_requestcomplainingorder" ("requestcomplainingorder_id"),
  CONSTRAINT "FKpjcqefb8km8b9xjl14trn9plk" FOREIGN KEY ("addproduct_id") REFERENCES "tbl_addingproductrequest" ("addproduct_id")
);

CREATE TABLE "tbl_transactionhistory" (
  "transactionhistory_id" int NOT NULL AUTO_INCREMENT,
  "amount" double NOT NULL,
  "description" varchar(255) DEFAULT NULL,
  "transaction_date" date DEFAULT NULL,
  "transaction_type" varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "account_id" int DEFAULT NULL,
  "orderbuy_id" int DEFAULT NULL,
  "orderrent_id" int DEFAULT NULL,
  PRIMARY KEY ("transactionhistory_id"),
  KEY "FKabcebtns5vt99ej4tjcabdqj4" ("account_id"),
  KEY "FKlbwr4k2wlwrbw8520xr52to56" ("orderbuy_id"),
  KEY "FKdb7qw3ynh6lipwjf56xa8eog6" ("orderrent_id"),
  CONSTRAINT "FKabcebtns5vt99ej4tjcabdqj4" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id"),
  CONSTRAINT "FKdb7qw3ynh6lipwjf56xa8eog6" FOREIGN KEY ("orderrent_id") REFERENCES "tbl_orderrent" ("orderrent_id"),
  CONSTRAINT "FKlbwr4k2wlwrbw8520xr52to56" FOREIGN KEY ("orderbuy_id") REFERENCES "tbl_orderbuy" ("orderbuy_id")
);

CREATE TABLE "tbl_voucher" (
  "voucher_id" int NOT NULL AUTO_INCREMENT,
  "created_date" date DEFAULT NULL,
  "description" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "discount_amount" int NOT NULL,
  "end_date" date DEFAULT NULL,
  "max_discount" int NOT NULL,
  "quantity" int NOT NULL,
  "start_date" date DEFAULT NULL,
  "status" varchar(255) DEFAULT NULL,
  "voucher_code" varchar(255) DEFAULT NULL,
  "voucher_name" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  "productowner_id" int DEFAULT NULL,
  "vouchertype_id" int DEFAULT NULL,
  PRIMARY KEY ("voucher_id"),
  KEY "FKj73gr2av4gwst2y5jxaijeou3" ("productowner_id"),
  KEY "FK477cy8dttyh2w2xm9hx40kpro" ("vouchertype_id"),
  CONSTRAINT "FK477cy8dttyh2w2xm9hx40kpro" FOREIGN KEY ("vouchertype_id") REFERENCES "tbl_vouchertype" ("vouchertype_id"),
  CONSTRAINT "FKj73gr2av4gwst2y5jxaijeou3" FOREIGN KEY ("productowner_id") REFERENCES "tbl_productowner" ("productowner_id")
);

CREATE TABLE "tbl_vouchertype" (
  "vouchertype_id" int NOT NULL AUTO_INCREMENT,
  "vouchertype_name" varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY ("vouchertype_id")
);

CREATE TABLE "tbl_wallet" (
  "wallet_id" int NOT NULL AUTO_INCREMENT,
  "balance" double NOT NULL,
  "coc_money" double NOT NULL,
  "created_date" date DEFAULT NULL,
  "pending_money" double NOT NULL,
  "account_id" int DEFAULT NULL,
  PRIMARY KEY ("wallet_id"),
  UNIQUE KEY "UK_583s2ga4n4ml49vin5h2w5s86" ("account_id"),
  CONSTRAINT "FKdp4fjpt5ggqcltchu1he1mxo3" FOREIGN KEY ("account_id") REFERENCES "tbl_account" ("account_id")
);
