import {test, expect} from '@playwright/test';

test('login', async ({page}) => {
    await page.goto('https://www.demoblaze.com/')

    //click on login button on home page.

    //await page.locator('#login2').click();
    await page.click('#login2');

    //enter data to text field username.

    //await page.fill('#loginusername','pavanol');
     await page.locator('#loginusername').fill('pavanol');

     //enter data to text field password.

     await page.fill('#loginpassword', 'test@123');
    
     //click on login button to login
     await page.click("//button[normalize-space()='Log in']");

     //valicating login
     const nameOfUser = await page.locator('#nameofuser');
     await expect(nameOfUser).toHaveText('Welcome pavanol');

     await page.close();

})