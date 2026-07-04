-- 1. キャラクターの登録
INSERT INTO characters (id, name, version) 
ON CONFLICT (id) DO NOTHING;

-- 2. セクション（カテゴリ）の登録
INSERT INTO sections (id, character_id, category) 
ON CONFLICT (id) DO NOTHING;

-- 3. 技（Move）の登録
INSERT INTO moves (
    id, section_id, name, input, 
    startup, startup_val, active, active_val, total, total_val, 
    hit_advantage, hit_advantage_val, guard_advantage, guard_advantage_val, 
    is_down, damage, cancel, attribute
) 
ON CONFLICT (id) DO NOTHING;