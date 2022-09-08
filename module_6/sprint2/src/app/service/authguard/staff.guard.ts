import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {CookieService} from "../cookie.service";
import {ToastrService} from "ngx-toastr";

@Injectable({
  providedIn: 'root'
})
export class StaffGuard implements CanActivate {
  constructor(private cookieService: CookieService,
              private router: Router,
              private toastrService: ToastrService) {
  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.cookieService.getCookie("jwToken") == '') {
      this.router.navigateByUrl("/error401").then(() => {
        this.toastrService.error("Vui lòng đăng nhập để tiếp tục!")
      })
      return false;
    }
    if (this.cookieService.getCookie("role") != "ROLE_STAFF") {
      this.router.navigateByUrl("/error403").then(() => {
        this.toastrService.error("Bạn không có quyền truy cập!")
      })
      return false;
    }
    return true;
  }

}
