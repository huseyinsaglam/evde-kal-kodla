import { Component, OnInit } from '@angular/core';
import {TranslateService} from "@ngx-translate/core";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  constructor(private translateService : TranslateService) {
    this.translateService.addLangs(['tr','en']); /*Dilleri ekleme yapiyorum*/
    const browserLang = this.translateService.getBrowserLang(); /*Tarayicinin dilini getiriyorum*/
    this.translateService.use(browserLang.match(/en|tr/) ? browserLang : 'en'); /*Bu dili kullan diyoruz*/

  }

  ngOnInit() {
  }

}
