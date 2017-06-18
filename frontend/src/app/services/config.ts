import { RestangularModule,Restangular  } from 'ngx-restangular';
export function RestangularConfigFactory (RestangularProvider) {
  RestangularProvider.setBaseUrl('http://217.182.230.17:8080');
  RestangularProvider.setFullResponse(true);
  RestangularProvider.addResponseInterceptor((data, operation, what, url, response)=> {
       console.log(data);
       console.log(url);
       console.log(what);

       return data;
    });
}
export class Config {
}
