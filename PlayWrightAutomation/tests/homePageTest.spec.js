const { test, expect } = require ('@playwright/test');

test('HomePage', async ({page})=>{
    await page.goto('https://www.demoblaze.com/');

    const pageTitle = await page.title();
    console.log('PageTitle is: ', pageTitle);

    await expect(page).toHaveTitle;

    const pageUrl =await page.url();
    console.log('Page Url is: ', pageUrl);

    await expect(page).toHaveURL('https://www.demoblaze.com/');
    
    await page.close;

})