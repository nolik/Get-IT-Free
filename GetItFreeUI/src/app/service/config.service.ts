import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';

@Injectable()
export class ConfigService {
  get add_advert_url(): string {
    return this._add_advert_url;
  }


  private _api_url = '/api';

  private _refresh_token_url = this._api_url + '/refresh';

  private _login_url = this._api_url + '/login';

  private _logout_url = this._api_url + '/logout';

  private _change_password_url = this._api_url + '/changePassword';

  private _reset_credentials_url = this._user_url + '/reset-credentials';

  private _signup_url = this._api_url + '/signup';

  private _adverts_url = this._api_url + '/adverts';

  private _add_advert_url= this._api_url + 'add-advert';

  get reset_credentials_url(): string {
    return this._reset_credentials_url;
  }

  get refresh_token_url(): string {
    return this._refresh_token_url;
  }

  get login_url(): string {
    return this._login_url;
  }

  get logout_url(): string {
    return this._logout_url;
  }

  get change_password_url(): string {
    return this._change_password_url;
  }

  get signup_url(): string {
    return this._signup_url;
  }

  get adverts_url(): string {
    return this._adverts_url;
  }

}
