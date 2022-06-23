import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ConfigActions } from 'src/app/core/theme/store/config.actions';
import { ThemeOptions } from 'src/app/shared/theme-options';

@Component({
  selector: 'app-main-base',
  templateUrl: './main-base.component.html',
  styleUrls: []
})
export class MainBaseComponent implements OnInit {
  @select('config') public config$: Observable<any>;
  constructor(public globals: ThemeOptions, public configActions: ConfigActions) { }

  ngOnInit(): void {
  }
  toggleSidebarMobile() {
    this.globals.toggleSidebarMobile = !this.globals.toggleSidebarMobile;
  }
}
