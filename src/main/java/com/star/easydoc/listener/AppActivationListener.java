package com.star.easydoc.listener;

import java.awt.*;
import java.net.URI;
import java.util.concurrent.atomic.AtomicLong;

import com.intellij.icons.AllIcons.General;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationAction;
import com.intellij.notification.NotificationDisplayType;
import com.intellij.notification.NotificationGroup;
import com.intellij.notification.NotificationListener;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.application.ApplicationActivationListener;
import com.intellij.openapi.diagnostic.Logger;
import com.intellij.openapi.wm.IdeFrame;
import com.star.easydoc.view.inner.SupportView;
import org.jetbrains.annotations.NotNull;

/**
 * 应用程序激活监听器
 *
 * @author wangchao
 * @date 2022/03/13
 */
public class AppActivationListener implements ApplicationActivationListener {
    private static final Logger LOGGER = Logger.getInstance(AppActivationListener.class);

    /** 上一次通知时间 */
    private final AtomicLong lastNoticeTime = new AtomicLong(0L);
    /** 通知时间间隔 */
    private static final long INTERVAL = 7 * 24 * 60 * 60 * 1000L;

    @Override
    public synchronized void applicationActivated(@NotNull IdeFrame ideFrame) {
        //if (System.currentTimeMillis() - lastNoticeTime.get() < INTERVAL) {
        //    return;
        //}
        //NotificationGroup group = new NotificationGroup("Easy Javadoc", NotificationDisplayType.BALLOON, true, null,
        //    General.AddJdk);
        //Notification notification = group.createNotification(
        //    "支持EasyJavadoc", "如果这款小而精的插件为您节约了不少时间，请支持一下开发者！",
        //    NotificationType.INFORMATION, NotificationListener.URL_OPENING_LISTENER);
        //
        //// 去点star
        //notification.addAction(new NotificationAction("✨ 去点star") {
        //    @Override
        //    public void actionPerformed(@NotNull AnActionEvent e, @NotNull Notification notification) {
        //        try {
        //            Desktop dp = Desktop.getDesktop();
        //            if (dp.isSupported(Desktop.Action.BROWSE)) {
        //                dp.browse(URI.create("https://github.com/starcwang/easy_javadoc"));
        //            }
        //        } catch (Exception ex) {
        //            LOGGER.error("打开链接失败:https://github.com/starcwang/easy_javadoc", ex);
        //        }
        //    }
        //});
        //
        //// 支付
        //notification.addAction(new NotificationAction("☕ 请喝咖啡") {
        //    @Override
        //    public void actionPerformed(@NotNull AnActionEvent e, @NotNull Notification notification) {
        //        SupportView supportView = new SupportView();
        //        supportView.show();
        //    }
        //});
        //
        //notification.notify(null);
        //lastNoticeTime.set(System.currentTimeMillis());
    }

    @Override
    public void applicationDeactivated(@NotNull IdeFrame ideFrame) {
        applicationActivated(ideFrame);
    }
}