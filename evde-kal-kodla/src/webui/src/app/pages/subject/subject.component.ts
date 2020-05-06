import { Component, OnInit } from '@angular/core';
import {SubjectService} from "../../services/shared/subject.service";

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.scss']
})
export class SubjectComponent implements OnInit {

  // pagination bilgilerini tutan propertyler
  rows = [];
  columns = [];
  loadingIndicator = true;
  reorderable = true;

  constructor(private subjectService : SubjectService) {

    this.fetch(data => {
      this.rows = data;
    });
  }

  ngOnInit() {
  }


  // https://www.positronx.io/create-ionic-data-table-with-ngx-datatable/
  fetch(cb) {
    this.subjectService.getAll().subscribe(
      projectData => {

        this.rows = projectData.content;

      }
    )
  }

}
