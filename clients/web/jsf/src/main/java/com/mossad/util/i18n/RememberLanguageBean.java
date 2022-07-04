/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mossad.util.i18n;

import com.mossad.util.cookies.CookiesOperations;
import jakarta.servlet.http.Cookie;
import java.io.Serializable;
/**
 * @author Buba
 */

public class RememberLanguageBean extends CookiesOperations implements Serializable {

    private static final String LANGUAGE_COOKIE_NAME = "i18nMSDLanguageCookie";
    private String language = "";

    public RememberLanguageBean() {
        checkLanguageCookie();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Saves selected language to cookie.
     *
     * @param language Language String
     */
    public void saveLanguageToCookie(String language) {
        saveStringToCookie(LANGUAGE_COOKIE_NAME, language);
    }

    /**
     * Deletes language cookie.
     */
    public void deleteLanguageCookie() {
        deleteCookie(LANGUAGE_COOKIE_NAME);
    }

    private void checkLanguageCookie() {
        Cookie cookie = getCookieByName(LANGUAGE_COOKIE_NAME);

        if (cookie != null) {
            language = cookie.getValue();
        }
    }
}
