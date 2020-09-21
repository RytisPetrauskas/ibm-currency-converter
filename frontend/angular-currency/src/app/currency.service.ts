import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Currency} from './Currency'
@Injectable({
  providedIn: 'root'
})

export class CurrencyService {

  constructor(private http:HttpClient) { }

  public getCurrencyList() {
    let link = "https://ibm-rytis-petrauskas.herokuapp.com/currencies";
    return this.http.get<any>(link);
  }

  public getCurrencyRates(firstAbv: string, secondAbv: string){
    let link = "https://ibm-rytis-petrauskas.herokuapp.com/currencyRate/" + firstAbv + "/" + secondAbv;
    return this.http.get<any>(link);
  }

}
