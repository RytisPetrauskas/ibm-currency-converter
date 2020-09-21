import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import {CurrencyService} from '../currency.service';
import {Currency} from '../Currency'

@Component({
  selector: 'app-currency',
  templateUrl: './currency.component.html',
  styleUrls: ['./currency.component.css']
})
export class CurrencyComponent implements OnInit {
  startingCurrency1: string = "EUR";
  startingCurrency2: string = "USD";
  currencies: Currency[] = [];
  converted: string;
  @ViewChild('firstSelect') firstSelect: ElementRef;
  @ViewChild('secondSelect') secondSelect: ElementRef;
  @ViewChild('label') label: ElementRef;
  @ViewChild('input') input: ElementRef;

  constructor(private currencyService: CurrencyService) { }

  ngOnInit(): void {
      let resp = this.currencyService.getCurrencyList();
      resp.toPromise().then(data=>{
        for(let x of data){
          this.currencies.push(new Currency(x[0],x[1]));
        }
      });

      this.initCalculations(this.startingCurrency1,this.startingCurrency2,1);
  }

  btnClick= function () {
    let temp = this.firstSelect.nativeElement.value;
    this.firstSelect.nativeElement.value = this.secondSelect.nativeElement.value;
    this.secondSelect.nativeElement.value = temp;
    this.initCalculations(this.firstSelect.nativeElement.value,this.secondSelect.nativeElement.value,this.input.nativeElement.value);
  };

  initCalculations(firstAbv: string, secondAbv: string, inputValue: number): void{
    let resp = this.currencyService.getCurrencyRates(firstAbv.substring(0,3),secondAbv.substring(0,3));
    resp.toPromise().then(data=>{
      let firstRate = data.find(element=> element[0]==firstAbv.substring(0,3));
      let secondRate = data.find(element=> element[0]==secondAbv.substring(0,3));
      this.converted = (inputValue*(1.0/firstRate[1])*secondRate[1]).toFixed(5);
    });
  }

  public onChange(): void{
    this.initCalculations(this.firstSelect.nativeElement.value,this.secondSelect.nativeElement.value,this.input.nativeElement.value);
  }

}
