-- Очистка старых данных (если нужно)
DELETE FROM pizza_ingredients;
DELETE FROM pizza;
DELETE FROM ingredient;

-- Тесто
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00),
('THIN_DOUGH', 'Тонкое тесто', 0, 50, 20.00);

-- Мясные ингредиенты
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('BACON', 'Бекон', 1, 18, 79.00),
('CHICKEN', 'Цыпленок', 1, 40, 79.00),
('HAM', 'Ветчина', 1, 40, 79.00),
('PEPPERONI', 'Пепперони', 1, 40, 79.00),
('SHRIMP', 'Креветки', 1, 40, 225.00);

-- Сыры и овощи
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('MOZZARELLA', 'Моцарелла', 2, 6, 40.00),
('DOUBLE_MOZZARELLA', 'Увеличенная порция моцареллы', 2, 8, 70.00),
('PARMESAN', 'Пармезан', 2, 6, 50.00),
('GOUDA', 'Гауда', 2, 10, 45.00),
('BLUE_CHEESE', 'Дорблю', 2, 10, 55.00),
('TOMATOES', 'Томаты', 2, 5, 59.00),
('ONION', 'Лук', 2, 5, 59.00),
('CUCUMBERS', 'Огурчики', 2, 5, 59.00),
('MUSHROOMS', 'Шампиньоны', 2, 15, 59.00),
('GARLIC', 'Чеснок', 2, 5, 29.00),
('PINEAPPLE', 'Ананас', 2, 5, 79.00);

-- Соусы и приправы
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('ITALIAN_HERBS', 'Итальянские травы', 3, 3, 59.00),
('TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00),
('ALFREDO_SAUCE', 'Фирменный соус альфредо', 3, 20, 199.00),
('TERIYAKI_SAUCE', 'Терияки соус', 3, 10, 129.00),
('RANCH_SAUCE', 'Ранч соус', 3, 5, 79.00);

INSERT INTO pizza (id, name, preparation_time, price, created_at, image_url) values
(1, 'Пепперони', 120, 350.00, CURRENT_TIMESTAMP(0), '/images/pizza-image.png'),
(2, 'Маргарита', 90, 320.00, CURRENT_TIMESTAMP(0), '/images/pizza-image.png'),
(3, 'Гавайская', 110, 380.00, CURRENT_TIMESTAMP(0), '/images/pizza-image.png'),
(4, 'Мясная', 130, 450.00, CURRENT_TIMESTAMP(0), '/images/pizza-image.png'),
(5, 'Вегетарианская', 95, 360.00, CURRENT_TIMESTAMP(0), '/images/pizza-image.png'),
(6, 'Четыре сыра', 100, 420.00, CURRENT_TIMESTAMP(0), '/images/pizza-image.png');


INSERT INTO pizza_ingredients (pizza_id, ingredient_id, quantity) values

-- Пепперони
(1, 'TRADITIONAL_DOUGH', 1),
(1, 'TOMATO_SAUCE', 1),
(1, 'MOZZARELLA', 1),
(1, 'PEPPERONI', 1),

-- Маргарита
(2, 'TRADITIONAL_DOUGH', 1),
(2, 'TOMATO_SAUCE', 1),
(2, 'MOZZARELLA', 2),
(2, 'ITALIAN_HERBS', 1),

-- Гавайская
(3, 'TRADITIONAL_DOUGH', 1),
(3, 'TOMATO_SAUCE', 1),
(3, 'MOZZARELLA', 1),
(3, 'CHICKEN', 2),
(3, 'PINEAPPLE', 1),

-- Мясная
(4, 'TRADITIONAL_DOUGH', 1),
(4, 'TOMATO_SAUCE', 1),
(4, 'BACON', 1),
(4, 'CHICKEN', 1),
(4, 'HAM', 1),
(4, 'PEPPERONI', 1),
(4, 'SHRIMP', 1),

-- Вегетарианская
(5, 'TRADITIONAL_DOUGH', 1),
(5, 'TOMATO_SAUCE', 1),
(5, 'MOZZARELLA', 1),
(5, 'TOMATOES', 1),
(5, 'ONION', 1),
(5, 'CUCUMBERS', 1),
(5, 'MUSHROOMS', 1),

-- Четыре сыра
(6, 'TRADITIONAL_DOUGH', 1),
(6, 'MOZZARELLA', 1),
(6, 'PARMESAN', 1),
(6, 'GOUDA', 1),
(6, 'BLUE_CHEESE', 1);