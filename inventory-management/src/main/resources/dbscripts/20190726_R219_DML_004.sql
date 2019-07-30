/*NAME: SN_PROD table
STORY_ID:20190725(4)
DESCRIPTION:Inserting data into SN_PROD table manually using INSERT command.
DATE:25/07/2019
APPROVED BY:
*/


/*DISABLING  TRIGGERS ON TABLE SN_PROD*/
ALTER TABLE SN_PROD DISABLE ALL TRIGGERS;


/*INSERTING DATA*/
INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SENSRS','Sensors','It is a mini device which makes sense on Lighting,Gas,temperature etc.',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('PIRSNSRS','PIR Sensors','used in security alarms and automatic lighting system',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MCWSNSRS','Microwave Sensors','used in door automation ,light automation ,alarm system and protection of open areas',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('OCCPSNSRS','Occupency Sensors','usedmost effectively in spaces that are rarely occupied whch may include: offices,warehouses etc.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('CONTSNSRS','Contact Sensors','this says about something is open or closed',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SWTCHS','Switches',' a high-speed device that receives incoming data packets and redirects them to their destination on a local area network (LAN).',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('GANG_SWTCH3','3 Gang Switch','Used to switch on and amp; off 3 types of loads.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('GANG_SWTCH1','1 Gang Switch','Used for only high rated appliances like AC’s and amp; geysers',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('FAN_SWTCH','Fan Switch','A single 2module switch which is used to control speed of the fan load.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('CURT_SWTCH','Curtain Switch','A single 2module switch which is used to open and amp; close the curtain.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('DIMR_SWTCH','Dimmer Switch','A single 2module switch which is used to control the brightness of the lights',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SCN_SWTCH','Scene Switch','The SceneSwitch is a 60-watt-equivalent, white-only LED bulb that’s capable of producing three color temperatures at the flip of a switch',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MSTR-SWTCH_L7','L7 Master Switch','can make routing decisions',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MSTR_SWTCH','Master Switch','that controls the action of relays or that makes and breaks the main supply line to a building or other installation',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('NODS','Nodes','A node is a point of intersection/connection within a network.',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MOD_2_NOD','2 Module Nodes','used to control two loads',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MOD_3_NOD','3 Module Nodes','used to control three loads',1,0,0);


INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('VCASST','Voice Assistance','Performs communication between devices,appliances and humans using diifferent technologies',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('ALEX_PROD_CAT','AlexaProduct','voice assistant Performs communication between devices,appliances and humans using diifferent technologies',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('GOOGLE_HOME','Google Home','voice assistant Performs communication between devices,appliances and humans using diifferent technologies',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('APPLE_SIRI','Apple Siri','voice assistant Performs communication between devices,appliances and humans using diifferent technologies',1,0,0);


INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('CAMS','Cameras','a device that can process the image',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('LOG_CIRCL','Logicircle','Home Security Camera ',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('RING_CAM','Ring Camera','Mi camera modelized with 360 degrees',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MI_CAM','MI Camera','camera with features like voice recording1',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('DRBELL','Door Bell','smart device which makes owners alert with a sound and image process',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('RING','Ring','smart device which makes owners alert with a sound and image process',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('DOOR_LOCK','Door Lock','It is a Bluetooth control door lock, using this device we can always in control of our frontdoor, no matter where we are',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('AGST','August','It is a Bluetooth control door lock, using this device we can always in control of our frontdoor, no matter where we are, right from your phone.',1,0,0);


INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('YALE','Yale','It is most popular product which can control the main door lock system using finger print,pin code, remote-control option etc.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('IR_BLSTRS','IR Blasters','IR blaster is a device that emulates an infrared remote control to autonomously control a device that is normally controlled only by remote control key presses.',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SNSBO','Sensibo','Sensibo is the ultimate device to control your air conditioner and heat pump and make it smart.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('LNBON','Lanbon','Help control home devices such as lighting curtain,fans socket etc.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SCKETS','Sockets','socket is one endpoint of a two-way communication link between two programs running on the network.',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('LNBON_SCKTS','Lanbon Sockets','it controls using lambon App',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SCKT_WT_SWTCH','Socket with Switch','combination of both smart socket and switch,controlled by alexa,android apps etc.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('SMRT_SOCKT','Smart Socket','3 pin smart socket which can be controlled by alexa,google assistant etc.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('LITNG_PRODS','Lighting Products','products that refer electric bulbs,LED etc',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('STRIP_LTNG','StripLighting','LED strip lights are safe as any other electrical lights',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('STR_CS_LTNG','StairCase Lighting','lighting mounted on steps',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('GAS_DTCTRS','Gas Detectors','Can be used to detect combustible,flammable and toxic gases which are harmful for organic life',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('MOTRS','Motors',' motor is an electrical machine that converts electrical energy into mechanical energy.',1,1,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('CRTN_MOTRS','Curtain Motors','To open and close curtains automatically',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('BLND_MOTRS','Blind Motors','this motors are used at windows for covering',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('ROLRS','Rollers','A roller is a cylinder that turns round in a machine or device.',1,0,0);

INSERT INTO SN_PROD(PROD_CD,PROD_NAME,PROD_DESC,ACT_IN,IS_PARNT_PROD,WORK_FLOW_IN )
VALUES('GATE_MOTRS','Gate Motors','The motor is used for opening and closing the gate by remote',1,0,0);


/*ENABLING  TRIGGERS ON TABLE SN_PROD*/
ALTER TABLE SN_PROD ENABLE ALL TRIGGERS;