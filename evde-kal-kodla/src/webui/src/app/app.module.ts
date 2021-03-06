import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppLayoutComponent } from './_layout/app-layout/app-layout.component';
import { FooterComponent } from './_layout/footer/footer.component';
import { HeaderComponent } from './_layout/header/header.component';
import { SidebarComponent } from './_layout/sidebar/sidebar.component';
import {ApiService} from "./services/api.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {TranslateHttpLoader} from "@ngx-translate/http-loader";
import {TranslateLoader, TranslateModule} from "@ngx-translate/core";
import {CommonModule} from "@angular/common";
import {UserService} from "./services/shared/user.service";
import {ProjectService} from "./services/shared/project.service";
import {SubjectService} from "./services/shared/subject.service";
import {SubjectHistoryService} from "./services/shared/subjectHistory.service";



/* Translate servisini kullanmamız icin tanimlama kismi . Http Client uzerinden bu json dosyalari sunucudan getirir.*/
export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}


@NgModule({
  declarations: [
    AppComponent, 
    AppLayoutComponent,
    FooterComponent,
    HeaderComponent,
    SidebarComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule,
    NgxDatatableModule,

    /* i18n initilazion kısmımı module ekleme kısmı*/
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: createTranslateLoader,
        deps: [HttpClient]
      }
    })
  ],
  providers: [ApiService,UserService,ProjectService,SubjectService,SubjectHistoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
