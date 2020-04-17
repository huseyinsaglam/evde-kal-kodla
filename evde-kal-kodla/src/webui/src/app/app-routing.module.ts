import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  {
    path: '',
    children: [
      {path: '', pathMatch: 'full', redirectTo: 'dashboard'}, /*default geldiginde dashboard bu path'e gotur*/
      {path: 'dashboard', loadChildren: './pages/dashboard/dashboard.module#DashboardModule'},
      {path: 'subject', loadChildren: './pages/subject/subject.module#SubjectModule'},
      {path: 'project', loadChildren: './pages/project/project.module#ProjectModule'},
      /*{path: 'gelen_path', loadChildren: './kokpaket/Klasör ismi/Dosya_ismi#Class_name'},*/
      /* subject geldiginde SubjectModule ne yonlendir, project geldiginde ProjectModule ne yonlendir */

    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
