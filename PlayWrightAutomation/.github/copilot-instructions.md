<!--
This file is authored to help AI coding agents be productive in this Playwright test repository.
Keep it short, actionable and specific to the files and patterns in this repo.
-->
# Copilot instructions for PlayWrightAutomation

Purpose: Short, repository-specific guidance for AI agents working on Playwright tests.

- **Big picture**: This repository is a Playwright test suite. Tests live under the [tests](tests) directory and are executed by `@playwright/test` (see [package.json](package.json)). The test runner is configured in [playwright.config.js](playwright.config.js) with `testDir: './tests'`, HTML reporter, `trace: 'on-first-retry'`, `fullyParallel: true`, and browser projects for `chromium`, `firefox`, and `webkit`.

- **Key files**:
  - [playwright.config.js](playwright.config.js) : central configuration (projects, reporter, trace, testDir).
  - [package.json](package.json) : lists `@playwright/test` in `devDependencies`; scripts are currently empty so use `npx` commands (examples below).
  - [tests/example.spec.js](tests/example.spec.js) and [tests/locatorsPrac.spec.js](tests/locatorsPrac.spec.js) : canonical test examples and selector/style patterns used in this repo.

- **How to run tests (developer workflows)**:
  - Install deps: `npm install` (project uses Node/npm). If missing, run `npm i`.
  - Run all tests: `npx playwright test`
  - Run a single file: `npx playwright test tests/locatorsPrac.spec.js`
  - Run a single test by title: `npx playwright test -g "login"`
  - Open the HTML report after a run: `npx playwright show-report` (Playwright's report CLI uses the reporter configured in `playwright.config.js`).
  - CI notes: `playwright.config.js` checks `process.env.CI` (affects `forbidOnly`, `retries`, and `workers`).

- **Conventions & patterns found in code**:
  - Tests import from `@playwright/test` and use `test` / `expect` (`import { test, expect } from '@playwright/test'`).
  - Prefer `page.locator(selector).fill()` or `page.click(selector)` patterns; examples: `#login2`, `#loginusername`, `#nameofuser` in [tests/locatorsPrac.spec.js](tests/locatorsPrac.spec.js).
  - Examples include both ARIA-based selectors (`getByRole`) as in [tests/example.spec.js](tests/example.spec.js) and XPath usage (`"//button[normalize-space()='Log in']"`) — maintain existing style when changing similar tests.
  - Test files are plain JavaScript (`.spec.js`) and placed directly in `tests/`.

- **What AI agents should do (task-focused guidance)**:
  - When editing tests, keep changes minimal and idiomatic: use `test()` blocks, `page` fixtures, and `expect()` assertions. Mirror existing locator styles in the same file (don't replace all XPath with `getByRole` unless requested).
  - When adding new scripts, prefer adding `npm` script entries to `package.json` (e.g., `"test": "playwright test"`) instead of instructing users to always use `npx`.
  - Use `trace: 'on-first-retry'` behavior — if proposing retries or trace changes, ensure CI behavior still matches `process.env.CI` expectations.
  - Avoid adding new top-level dependencies unless necessary; prefer Playwright built-ins.

- **Examples to follow**:
  - Small smoke test pattern (from `tests/example.spec.js`): navigate with `page.goto`, use `getByRole` for accessibility-based actions, and assert with `expect(page).toHaveTitle()` or `expect(locator).toBeVisible()`.
  - Login flow pattern (from `tests/locatorsPrac.spec.js`): click a button, fill username/password, click confirm, then assert user label text `#nameofuser`.

- **Integration points & external deps**:
  - Primary dependency: `@playwright/test` (see [package.json](package.json)).
  - No webServer is configured in `playwright.config.js` (the `webServer` block is commented out). If adding tests that require a local dev server, update `playwright.config.js` accordingly.

- **Code style & PR expectations**:
  - Keep changes confined to `tests/` and `playwright.config.js` unless explicitly modifying tooling.
  - Keep tests readable and small; follow existing naming and file placement conventions.

If any part of the repo has implicit conventions I missed, tell me which area (tests, config, CI) and I will update this file. Feedback welcome.
