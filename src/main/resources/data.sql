-- Очистка старых данных (если нужно)
DELETE FROM pizza_ingredients;
DELETE FROM pizza;
DELETE FROM ingredient;

-- Тесто - DOUGH - 0
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00),
('THIN_DOUGH', 'Тонкое тесто', 0, 50, 20.00);

-- Мясные ингредиенты - MEAT - 1
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('BACON', 'Бекон', 1, 18, 79.00),
('CHICKEN', 'Цыпленок', 1, 40, 79.00),
('HAM', 'Ветчина', 1, 40, 79.00),
('PEPPERONI', 'Пепперони', 1, 40, 79.00),
('SHRIMP', 'Креветки', 1, 40, 225.00);

-- Сыры и овощи - VEGGIES - 2
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

-- Соусы и приправы - SAUCE - 3
INSERT INTO ingredient (id, name, type, preparation_time, price) VALUES
('ITALIAN_HERBS', 'Итальянские травы', 3, 3, 59.00),
('TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00),
('ALFREDO_SAUCE', 'Фирменный соус альфредо', 3, 20, 199.00),
('TERIYAKI_SAUCE', 'Терияки соус', 3, 10, 129.00),
('RANCH_SAUCE', 'Ранч соус', 3, 5, 79.00);

INSERT INTO pizza (name, preparation_time, price, created_at, image_url) values
('Пепперони', 120, 350.00, CURRENT_TIMESTAMP(0), '/images/pizza.png'),
('Маргарита', 90, 320.00, CURRENT_TIMESTAMP(0), '/images/pizza.png'),
('Гавайская', 110, 380.00, CURRENT_TIMESTAMP(0), '/images/pizza.png'),
('Мясная', 130, 450.00, CURRENT_TIMESTAMP(0), '/images/pizza.png'),
('Вегетарианская', 95, 360.00, CURRENT_TIMESTAMP(0), '/images/pizza.png'),
('Четыре сыра', 100, 420.00, CURRENT_TIMESTAMP(0), '/images/pizza.png');

-- Начинка пицц
INSERT INTO pizza_ingredients (pizza_id, ingredient_id, name,
                                type, preparation_time, price, quantity) values

-- Пепперони
(1, 'TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00, 1),
(1, 'TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00, 1),
(1, 'MOZZARELLA', 'Моцарелла', 2, 6, 40.00, 1),
(1, 'PEPPERONI', 'Пепперони', 1, 40, 79.00, 1),

-- Маргарита
(2, 'TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00, 1),
(2, 'TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00, 1),
(2, 'MOZZARELLA', 'Моцарелла', 2, 6, 40.00, 2),
(2, 'ITALIAN_HERBS', 'Итальянские травы', 3, 3, 59.00, 1),

-- Гавайская
(3, 'TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00, 1),
(3, 'TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00, 1),
(3, 'MOZZARELLA', 'Моцарелла', 2, 6, 40.00, 1),
(3, 'CHICKEN', 'Цыпленок', 1, 40, 79.00, 2),
(3, 'PINEAPPLE', 'Ананас', 2, 5, 79.00, 1),

-- Мясная
(4, 'TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00, 1),
(4, 'TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00, 1),
(4, 'BACON', 'Бекон', 1, 18, 79.00, 1),
(4, 'CHICKEN', 'Цыпленок', 1, 40, 79.00, 1),
(4, 'HAM', 'Ветчина', 1, 40, 79.00, 1),
(4, 'PEPPERONI', 'Пепперони', 1, 40, 79.00, 1),
(4, 'SHRIMP', 'Креветки', 1, 40, 225.00, 1),

-- Вегетарианская
(5, 'TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00, 1),
(5, 'TOMATO_SAUCE', 'Фирменный томатный соус', 3, 25, 225.00, 1),
(5, 'MOZZARELLA', 'Моцарелла', 2, 6, 40.00, 1),
(5, 'TOMATOES', 'Томаты', 2, 5, 59.00, 1),
(5, 'ONION', 'Лук', 2, 5, 59.00, 1),
(5, 'CUCUMBERS', 'Огурчики', 2, 5, 59.00, 1),
(5, 'MUSHROOMS', 'Шампиньоны', 2, 15, 59.00, 1),

-- Четыре сыра
(6, 'TRADITIONAL_DOUGH', 'Традиционное тесто', 0, 40, 25.00, 1),
(6, 'MOZZARELLA', 'Моцарелла', 2, 6, 40.00, 1),
(6, 'PARMESAN', 'Пармезан', 2, 6, 50.00, 1),
(6, 'GOUDA', 'Гауда', 2, 10, 45.00, 1),
(6, 'BLUE_CHEESE', 'Дорблю', 2, 10, 55.00, 1);
