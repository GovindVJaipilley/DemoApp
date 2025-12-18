/*
page.getByRole() to locate by explicit and implicit accessibility attributes.
page.getByText() to locate by text content.
page.getByLabel() to locate a form control by associated label's text.
page.getByPlaceholder() to locate an input by placeholder.
page.getByAltText() to locate an element, usually image, by its text alternative.
page.getByTitle() to locate an element by its title attribute.
page.getByTestId() to locate an element based on its data-testid attribute (other attributes can be configured).
*/

import {test, expect} from '@playwright/test';

test('InbuildLocators', async ({page})=>{
  
    // using getByAltText.
    await page.goto('https://govind-osondemand.orangehrm.com/dashboard/index');
    const logo = page.getByAltText('company-branding');
    await expect (logo).toBeVisible();

    // using getByPlaceholder.
    await page.getByPlaceholder('Username').fill('Admin');
    await page.getByPlaceholder('Password').fill('@gh@UOJ8Q9r@');

    // using getByRole
    await page.getByRole('button').click();

    // using getByText
     const userName = page.getByText('Govind Jaipilley');
     await expect (userName).toBeVisible();

     page.close;

})