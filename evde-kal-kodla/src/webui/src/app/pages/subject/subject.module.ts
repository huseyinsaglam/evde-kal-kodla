import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SubjectComponent } from './subject.component';
import {SubjectRoutingModule} from "./subject-routing.module";
import {SubjectService} from "../../services/shared/subject.service";
import {SharedModule} from "../../shared/shared.module";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import { SubjectDetailComponent } from './subject-detail/subject-detail.component';



@NgModule({
  declarations: [SubjectComponent, SubjectDetailComponent],
  imports: [
    CommonModule,
    NgxDatatableModule,
    SubjectRoutingModule,
    SharedModule
  ],
  providers:[SubjectService]  // Subject Modulunde kullanacagimiz lokal servisimiz...
})
export class SubjectModule { }
