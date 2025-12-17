import {test, expert} from '@playwright/test';

test('Multiple Locators Practice', async ({page}) => {

    await page.goto('https://www.demoblaze.com/');
    const links = await page.$$('a');

    const count = await links.length;
    console.log('Total number of links on the page: ', count);

    for(const link of links){
        const linkText = await link.textContent();
        console.log('Link Text: ', linkText);
    }
    await page.waitForSelector("//div[@id='tbodyid']//div/h4/a");
    const productsList = await page.locator("//div[@id='tbodyid']//div/h4/a");
    const productsCount = await productsList.count();
    console.log('Total number of products: ', productsCount);
    
   
    for(let i=0; i<productsCount; i++){
        const productName = await productsList.nth(i).textContent();
        console.log('Product Name: ', productName);
    }

    await page.close();
})  