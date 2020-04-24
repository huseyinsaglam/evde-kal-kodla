import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SubjectComponent } from './subject.component';
import {SubjectRoutingModule} from "./subject-routing.module";
import {SubjectService} from "../../services/shared/subject.service";



@NgModule({
  declarations: [SubjectComponent],
  imports: [
    CommonModule,
    SubjectRoutingModule
  ],
  providers:[SubjectService]  // Subject Modulunde kullanacagimiz lokal servisimiz...
})
export class SubjectModule { }
