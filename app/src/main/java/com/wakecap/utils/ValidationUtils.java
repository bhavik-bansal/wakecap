package com.wakecap.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;
import java.util.regex.Pattern;

/**
 * VALIDATION UTILS USED FOR SOME BASIC VALIDATION
 */

public class ValidationUtils {
    private static final String TAG = ValidationUtils.class.getSimpleName();
    private static final String ERROR_TEXT = " is required.";
    private static final String ERROR_TEXT_LENGTH = " minimum Length required is ";

    private static final String MOBILE_NUMBER_LENGTH_ERROR = "Phone number is minimum 6 digit above.";
    private static final String PASSWORD_ERROR_TEXT = "Password must be between 6 to 30 characters.";
    private static final String EMAIL_ERROR_TEXT = "Please enter a valid email address.";
    private static final String EMAIL = "Email";
    private static final String PASSWORD = "Password";
    private static final String MOBILE = "Mobile";
    private static final int PASSWORD_MIN_LENGTH = 6;
    private static final int PASSWORD_MAX_LENGTH = 30;
    private static final String MINMUM_LENGTH_ERROR = "  is must be above 3 character.";
    private static final String HOURS = "Hour";
    private static final String HOUR_ERROR_TEXT = "Please enter valid hour.";

    private static final String EmailRegex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Check String is Valid or Not
     *
     * @param string
     * @return
     */
    public static boolean isValidString(String string) {
        try {
            if (string != null && string.length() > 0 && !string.isEmpty())
                return true;
            else
                return false;
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static boolean isValidStringWithZeroLength(String string) {
        try {
            if (string != null && string.length() >= 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    /**
     * get String from edit text
     *
     * @param editText
     * @return
     */
    public static String getString(EditText editText) {
        try {
            if (editText != null) {
                if (isValidString(editText.getText().toString()))
                    return editText.getText().toString();
                else
                    return "";
            } else {
                AppLog.d(TAG, "Edit text is null");
                return "";
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return "";
        }
    }

    /**
     * get String from edit text and check valid or not
     *
     * @param editText
     * @return
     */
//Add error hint on empty To-Do
    public static boolean isValidStringToDo(EditText editText, String hint) {
        try {
            hint.replace('*', ' ');
            if (editText != null)
                if (isValidString(getString(editText))) {
//                    if (getString(editText).length() >= 3) {
                    editText.setError(null);
                    return true;
//                    } else {
//                        editText.setError(hint + MINMUM_LENGTH_ERROR);
//                        editText.requestFocus();
//                        return false;
//                    }
                } else {
                    editText.setError(hint);
                    editText.requestFocus();
                    return false;
                }
            else {
                AppLog.d(TAG, "Edit text is null");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean isActivityRunning(Activity activity){
        if(activity==null || activity.isFinishing() || activity.isDestroyed())
            return false;
        else
            return true;
    }

    public static boolean isValidString(EditText editText, String hint) {
        try {
            hint.replace('*', ' ');
            if (editText != null)
                if (isValidString(getString(editText))) {
//                    if (getString(editText).length() >= 3) {
                    editText.setError(null);
                    return true;
//                    } else {
//                        editText.setError(hint + MINMUM_LENGTH_ERROR);
//                        editText.requestFocus();
//                        return false;
//                    }
                } else {
                    editText.setError(hint + ERROR_TEXT);
                    editText.requestFocus();
                    return false;
                }
            else {
                AppLog.d(TAG, "Edit text is null");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static boolean isValidStringLength(EditText editText, String hint, int minlength) {
        try {
            hint.replace('*', ' ');
            if (editText != null){
                if (isValidString(getString(editText))&& editText.getText().length()>=minlength) {
                    editText.setError(null);
                    return true;
                } else {
                    editText.setError(hint + ERROR_TEXT_LENGTH + minlength);
                    editText.requestFocus();
                    return false;
                }
            }
            else {
                AppLog.d(TAG, "Edit text is null");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    /**
     * check list is valid or not
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> boolean isValidList(List<T> list) {
        try {
            if (list != null && !list.isEmpty() && list.size() > 0)
                return true;
            else
                return false;
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    /**
     * check object valid or not
     *
     * @param object
     * @param <T>
     * @return
     */
    public static <T> boolean isValidObject(T object) {
        try {
            if (object != null)
                return true;
            else
                return false;
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }


    /**
     * password validation for check is valid or not
     * also check its length above minimum character
     *
     * @param editText
     * @return
     */
    public static boolean isValidPassword(EditText editText) {
        try {
            if (isValidObject(editText)) {

                if (isValidString(editText, PASSWORD)) {

                    editText.setError(null);
                    if (getString(editText).length() >= PASSWORD_MIN_LENGTH
                            && getString(editText).length() <= PASSWORD_MAX_LENGTH) {
                        return true;
                    } else {
                        editText.requestFocus();
                        editText.setError(PASSWORD_ERROR_TEXT);
                        return false;
                    }

                } else {
                    AppLog.d(TAG, "isValidPassword hint" + editText.getHint());
                    editText.setError(PASSWORD + ERROR_TEXT);
                    return false;

                }
            } else {
                AppLog.d(TAG, "Edit text is null");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static boolean isValidPhone(EditText editText, int length, boolean allowEmpty){
        if(isValidObject(editText)){
            if(editText.getText().toString().trim().length()==0 && allowEmpty)
                return true;
            else if(editText.getText().toString().trim().length()<length) {
                return false;
            }else
                return true;
        }
        return false;
    }


    public static boolean isValidMinIntValue(EditText editText, int minValue, boolean allowEmpty){
        if(isValidObject(editText)){
            int value=Integer.parseInt(editText.getText().toString().trim().toString());
            if(editText.getText().toString().trim().length()==0 && allowEmpty)
                return false;
            else if(value<minValue) {
                return false;
            }else
                return true;
        }
        return false;
    }


    public static boolean isValidEmail(EditText editText) {
        try {
            if (isValidObject(editText)) {
                if (isValidString(editText, EMAIL)) {
                    Pattern pattern = Pattern.compile(EmailRegex);

             /*       if (android.util.Patterns.EMAIL_ADDRESS.matcher(getString(editText).trim())
                            .matches()) {
                        return true;
                    }*/
                    if(pattern.matcher(getString(editText).trim()).matches()){
                        return true;
                    }
                    else {
                        editText.requestFocus();
                        editText.setError(EMAIL_ERROR_TEXT);
                        return false;
                    }
                } else {
                    editText.requestFocus();
                    editText.setError(EMAIL + ERROR_TEXT);
                    return false;
                }
            } else {
                AppLog.d(TAG, "Edit text is null.");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static boolean isValidateGender(Spinner spinner) {
        try {
            if (spinner != null && spinner.getSelectedItemPosition() != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }

    public static boolean isValidMobileNumber(EditText editText) {
        try {
            if (editText != null) {
                if (isValidString(getString(editText))) {
                    if (getString(editText).length() >= 10) {
                        return true;
                    } else {
                        editText.requestFocus();
                        editText.setError(MOBILE_NUMBER_LENGTH_ERROR);
                        return false;
                    }
                } else {
                    editText.requestFocus();

                    editText.setError(MOBILE + ERROR_TEXT);
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }
    public static boolean isValidInt(long userInput){
        if (userInput > Integer.MAX_VALUE || userInput < Integer.MIN_VALUE) {
            return false;
        }  else {
            return  true;
        }
    }

    public static boolean isIntGreaterZero(long userInput){
        if (userInput > Integer.MAX_VALUE || userInput < Integer.MIN_VALUE) {
            return false;
        }
        if(userInput>0)
            return true;
        else {
            return  false;
        }
    }

    /**
     * get String from edit text
     *
     * @param string
     * @return
     */
    public static String getValidString(String string) {
        try {
            if (isValidString(string)) {
                return string;
            } else {
                AppLog.d(TAG, "string text is null");
                return "";
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return "";
        }
    }


    /**
     * get String from edit text and check valid or not
     *
     * @param editText
     * @return
     */
    public static boolean isValidString(TextInputLayout layout, EditText editText, String hint) {
        try {
//            editText.getBackground().mutate().setColorFilter(
//                    ContextCompat.getColor(getContext(), R.color.white),
//                    PorterDuff.Mode.SRC_ATOP);
            layout.setErrorEnabled(true);
//            layout.setBackgroundColor(ResourceUtils.getColor(editText.getContext(), R.color.sep));
//            editText.setBackgroundResource(R.drawable.edt_selector);
            if (layout != null)
                if (isValidString(getString(editText))) {
                    layout.setError(null);
                    return true;
                } else {
                    layout.setError(hint + ERROR_TEXT);
                    return false;
                }
            else {
                AppLog.d(TAG, "Edit text is null");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }


    public static boolean isValidHours(EditText editText) {
        try {
            if (isValidObject(editText)) {

                if (isValidString(editText, HOURS)) {

                    editText.setError(null);
                    String hourText = editText.getText().toString();
                    Float hour = Float.valueOf(hourText);
                    if (hour > 00.00f && hour <= 24.00f) {
                        return true;
                    } else {
                        editText.requestFocus();
                        editText.setError(HOUR_ERROR_TEXT);
                        return false;
                    }

                } else {
                    AppLog.d(TAG, "isValidPassword hint" + editText.getHint());
                    editText.setError(HOURS + ERROR_TEXT);
                    return false;

                }
            } else {
                AppLog.d(TAG, "Edit text is null");
                return false;
            }
        } catch (Exception e) {
            AppLog.e(TAG, e.getMessage(), e);
            return false;
        }
    }
}
