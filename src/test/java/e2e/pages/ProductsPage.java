package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='shop-main-navigation']")
    WebElement container;

    public void waitForLoadingProductsPage() {
        getWait().forVisibility(container);
        Assert.assertTrue(container.isDisplayed());
    }

    public void checkIfAllProductsHaveCorrectName(String productNameIWrite) throws InterruptedException {
        // Инициализируем счётчик страниц (pageCount) с 0 и устанавливаем максимальное количество страниц для проверки в 6
        int pageCount = 0;
        int maxPages = 6;

        // Запускаем цикл, который продолжается, пока проверено меньше 6 страниц
        while (pageCount < maxPages) {
            // Делаем паузу на 1 секунду перед тем, как начать проверку, чтобы дать время странице загрузиться
            Thread.sleep(1000);

            // Находим все элементы с названием продукта на странице (по определённому классу)
            List<WebElement> products = driver.findElements(By.xpath("//*[@class='ProductListItem_productInfoTitle__PUtxb']"));

            // Ждём, пока все найденные элементы с продуктами станут видимыми на странице
            getWait().forAllVisibility(products);

            // Проходим через каждый продукт на странице и проверяем его название
            for (WebElement product : products) {
                // Получаем название текущего продукта
                String productName = product.getText();

                // Если название продукта не содержит ожидаемое имя, выбрасываем ошибку и завершаем тест
                if (!productName.contains(productNameIWrite)) {
                    throw new AssertionError("Not all products have correct name");
                } else {
                    // Если название продукта правильное, выводим сообщение, что всё в порядке
                    System.out.println("All products have correct name");
                }
            }

            // Пробуем найти кнопку "Weiter" (кнопка для перехода на следующую страницу)
            try {
                WebElement nextButton = driver.findElement(By.xpath("//span[contains(text(), 'Weiter')]"));

                // Если кнопка найдена и активна, кликаем по ней, чтобы перейти на следующую страницу
                nextButton.click();

                // Ждём, пока следующая страница полностью загрузится
                waitForLoadingProductsPage();
            } catch (NoSuchElementException e) {
                // Если кнопка "Weiter" не найдена, значит, это последняя страница, выводим сообщение и выходим из цикла
                System.out.println("No more pages, ending loop.");
                break;  // Прерываем цикл, так как больше нет страниц
            }

            // Увеличиваем счётчик страниц, так как мы успешно перешли на следующую страницу
            pageCount++;
        }
    }


}
