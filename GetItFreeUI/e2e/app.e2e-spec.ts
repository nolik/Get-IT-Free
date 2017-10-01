import { GetItFreeUIPage } from './app.po';

describe('get-it-free-ui App', () => {
  let page: GetItFreeUIPage;

  beforeEach(() => {
    page = new GetItFreeUIPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
