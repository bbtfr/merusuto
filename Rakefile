# -*- coding: utf-8 -*-
$:.unshift("/Library/RubyMotionCustom/lib")
require 'motion/project/template/android'

Motion::Project::App.setup do |app|
  # Use `rake config' to see complete project settings.
  app.name = '梅露可图鉴'
  app.theme = 'AppTheme'
  app.icon = 'ic_launcher'
  app.package = 'com.kagami.merusuto'

  app.vendor_project :jar => 'vendor/android-support-v4.jar'

  app.api_version = '14'
  app.target_api_version = '14'

  app.permissions += %w(ACCESS_NETWORK_STATE
    READ_EXTERNAL_STORAGE WRITE_EXTERNAL_STORAGE).map do |perm|
    "android.permission.#{perm}"
  end
end
